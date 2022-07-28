package banana.code.giphytesttask

import androidx.lifecycle.ViewModel
import banana.code.giphytesttask.data.GifRepository
import banana.code.giphytesttask.remote.GifRemoteInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    var gifRepository: GifRepository
): ViewModel()  {



}