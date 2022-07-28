package banana.code.giphytesttask.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import banana.code.giphytesttask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifFullscreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gif_fullscreen, container, false)
    }

}