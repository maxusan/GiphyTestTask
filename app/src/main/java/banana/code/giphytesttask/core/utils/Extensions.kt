package banana.code.giphytesttask.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import banana.code.giphytesttask.core.model.Gif
import com.bumptech.glide.Glide

@BindingAdapter("setGifImage")
fun ImageView.setGifImage(gif: Gif){
    Glide.with(this)
        .asGif()
        .load(gif.link)
        .into(this)
}