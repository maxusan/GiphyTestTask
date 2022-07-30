package banana.code.giphytesttask.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.data.response.Pagination
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.core.utils.Constants
import banana.code.giphytesttask.databinding.FragmentGifsBinding
import banana.code.giphytesttask.ui.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifsFragment : Fragment() {

    private lateinit var binding: FragmentGifsBinding
    private val adapter: GifsListAdapter by lazy { GifsListAdapter(){ gif: Gif ->
        handleGifClick(gif)
    } }

    private fun handleGifClick(gif: Gif) {
        findNavController().navigate(GifsFragmentDirections.actionMainFragmentToGifFullscreenFragment(gif))
    }

    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.gifsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.listMode.observe(viewLifecycleOwner) {
            switchListLayoutManager(it)
            binding.listMode = it
        }
        viewModel.paginationValue.observe(viewLifecycleOwner){
            it?.let {
                updatePageSwitchButtons(it)
            }
        }
    }

    private fun updatePageSwitchButtons(pagination: Pagination) {
        pagination.apply {
            binding.previousPageButton.isEnabled =
                (viewModel.getOffsetValue() - Constants.QUERY_LIMIT) >= 0
            binding.nextPageButton.isEnabled =
                (viewModel.getOffsetValue() + Constants.QUERY_LIMIT) <= total_count
            binding.pageCounter.text =
                getString(R.string.page_n, viewModel.getOffsetValue() / Constants.QUERY_LIMIT)
        }
    }

    private fun setupViews() {
        binding.gifsList.adapter = adapter
        binding.switchListModeButton.setOnClickListener {
            viewModel.switchListMode()
        }
        binding.searchEt.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return query?.let {
                    viewModel.setQuery(
                        query = it
                    )
                    it.isNotEmpty()
                } ?: false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false

        })
        binding.nextPageButton.setOnClickListener {
            viewModel.nextPage()
        }
        binding.previousPageButton.setOnClickListener {
            viewModel.previousPage()
        }
    }

    private fun switchListLayoutManager(listMode: ListMode) {
        var scrollPosition = 0
        if (binding.gifsList.layoutManager != null) {
            scrollPosition = (binding.gifsList.layoutManager as LinearLayoutManager)
                .findFirstCompletelyVisibleItemPosition()
        }
        val layoutManager = when (listMode) {
            ListMode.GRID -> {
                GridLayoutManager(requireContext(), 2)
            }
            ListMode.LINEAR -> {
                LinearLayoutManager(requireContext())
            }
        }

        binding.gifsList.layoutManager = layoutManager
        binding.gifsList.adapter = adapter
        binding.gifsList.scrollToPosition(scrollPosition)
    }

}