package banana.code.giphytesttask.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import banana.code.giphytesttask.R
import banana.code.giphytesttask.databinding.FragmentGifFullscreenBinding
import banana.code.giphytesttask.ui.AppViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifFullscreenFragment : Fragment() {

    private lateinit var binding: FragmentGifFullscreenBinding
    private val viewModel: AppViewModel by activityViewModels()
    private val args: GifFullscreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifFullscreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .asGif()
            .load(args.gif.link)
            .into(binding.gifPreview)
    }

}