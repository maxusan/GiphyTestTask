package banana.code.giphytesttask.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.databinding.ListItemGridGifBinding

class GifsListAdapter(
    //val listType: ListMode
): ListAdapter<Gif, RecyclerView.ViewHolder>(GifCallback()) {


    inner class GridGifHolder(private val binding: ListItemGridGifBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindGif(gif: Gif?) {
            binding.gifPreview.setImageResource(R.drawable.ic_launcher_foreground)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ListItemGridGifBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_grid_gif,
            parent, false
        )
        return GridGifHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GridGifHolder).bindGif(currentList[position])
    }
}

class GifCallback: DiffUtil.ItemCallback<Gif>(){
    override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean = oldItem == newItem

}