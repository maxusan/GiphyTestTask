package banana.code.giphytesttask.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.databinding.ListItemGifFullscreenBinding

class GifFullscreenListAdapter(
) : ListAdapter<Gif, RecyclerView.ViewHolder>(Gif.getGifCallback()) {

    inner class GridGifHolder(private val binding: ListItemGifFullscreenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindGif(gif: Gif?) {
            binding.gif = gif
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ListItemGifFullscreenBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_gif_fullscreen,
            parent, false
        )
        return GridGifHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GridGifHolder).bindGif(currentList[position])
    }
}
