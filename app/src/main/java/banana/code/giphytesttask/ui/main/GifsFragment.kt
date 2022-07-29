package banana.code.giphytesttask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import banana.code.giphytesttask.databinding.FragmentGifsBinding
import banana.code.giphytesttask.ui.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifsFragment : Fragment() {

    private lateinit var binding: FragmentGifsBinding
    private val adapter: GifsListAdapter by lazy { GifsListAdapter() }
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
        binding.gifsList.adapter = adapter
        binding.switchListModeButton.setOnClickListener {
            viewModel.switchListMode()
        }
        viewModel.gifsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.listMode.observe(viewLifecycleOwner) {
            switchListLayoutManager(it)
            binding.listMode = it
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