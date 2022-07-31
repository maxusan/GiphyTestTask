package banana.code.giphytesttask.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import banana.code.giphytesttask.R
import banana.code.giphytesttask.databinding.FragmentGifFullscreenBinding
import banana.code.giphytesttask.ui.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifFullscreenFragment : Fragment() {

    private lateinit var binding: FragmentGifFullscreenBinding
    private val viewModel: AppViewModel by activityViewModels()
    private val args: GifFullscreenFragmentArgs by navArgs()
    private val pagerAdapter: GifFullscreenListAdapter by lazy { GifFullscreenListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifFullscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPager()
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.gifsList.observe(viewLifecycleOwner) {
            pagerAdapter.submitList(it)
            binding.gifsPager.currentItem = args.position
        }
    }

    private fun setupPager() {
        binding.gifsPager.apply {
            adapter = pagerAdapter
            offscreenPageLimit = 1
            val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx =
                resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
                page.alpha = 0.25f + (1 - kotlin.math.abs(position))
            }
            setPageTransformer(pageTransformer)
            val itemDecoration = HorizontalMarginItemDecoration(
                requireContext(),
                R.dimen.viewpager_current_item_horizontal_margin
            )
            addItemDecoration(itemDecoration)
        }

    }

}