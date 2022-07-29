package banana.code.giphytesttask.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.core.model.RetrofitResponse
import banana.code.giphytesttask.core.repository.GifRepository
import banana.code.giphytesttask.ui.main.ListMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    var gifRepository: GifRepository
): ViewModel()  {

    private val _gifsList = MutableLiveData<List<Gif>>()
    val gifsList: LiveData<List<Gif>> = _gifsList

    private val _listMode = MutableLiveData(ListMode.GRID)
    val listMode: LiveData<ListMode> = _listMode
    fun switchListMode(){
        when(listMode.value){
            ListMode.GRID -> _listMode.postValue(ListMode.LINEAR)
            ListMode.LINEAR -> _listMode.postValue(ListMode.GRID)
            else -> _listMode.postValue(ListMode.LINEAR)
        }
    }

    fun getGifsByQuery(query: String, offset: Int){
        viewModelScope.launch(Dispatchers.IO){
            val response = gifRepository.getGifsFromApi(
                query = "dogs",
                offset = 0
            )
            when(response){
                is RetrofitResponse.Error -> {}
                is RetrofitResponse.Success -> {
                    _gifsList.postValue(response.gifsList)
//                    response.gifsList.forEach {
//                        Log.e("logs", it.toString())
//                    }
                }
            }
        }
    }

}