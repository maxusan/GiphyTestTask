package banana.code.giphytesttask.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.databinding.ListItemGifBinding
import javax.inject.Inject

class GifsListAdapter @Inject constructor(
    val gifClick: (Int) -> Unit,
): ListAdapter<Gif, RecyclerView.ViewHolder>(Gif.getGifCallback()) {


    inner class GridGifHolder(private val binding: ListItemGifBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                gifClick(adapterPosition)
            }
        }

        fun bindGif(gif: Gif?) {
            binding.gif = gif
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ListItemGifBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_gif,
            parent, false
        )
        return GridGifHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GridGifHolder).bindGif(currentList[position])
    }
}