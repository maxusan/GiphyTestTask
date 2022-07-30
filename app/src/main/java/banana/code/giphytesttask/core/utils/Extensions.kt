package banana.code.giphytesttask.core.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
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

fun Context.hasNetwork(): Boolean {
    var isConnected: Boolean = false // Initial Value
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}