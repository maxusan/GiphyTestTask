package banana.code.giphytesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import banana.code.giphytesttask.AppViewModel
import banana.code.giphytesttask.R
import banana.code.giphytesttask.remote.GifRemoteInterface
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch(Dispatchers.IO){
//            gifs.getAllGifs(
//                "YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL",
//                limit = 20,
//                query = "dogs",
////                offset = 0
//                ).body()?.let {
//                    Log.e("logs", it.toString())
//            }
        }

    }
}