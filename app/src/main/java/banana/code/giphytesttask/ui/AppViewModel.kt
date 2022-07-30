package banana.code.giphytesttask.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banana.code.giphytesttask.core.db.dao.GifDao
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.core.model.RetrofitResponse
import banana.code.giphytesttask.core.repository.GifRepository
import banana.code.giphytesttask.ui.main.ListMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    var gifRepository: GifRepository,
    var gifDao: GifDao
): ViewModel()  {

    private val _gifsList = MutableLiveData<List<Gif>>()
    val gifsList: LiveData<List<Gif>> = _gifsList

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query
    fun getQueryValue(): String? = query.value
    fun setQuery(query: String){
        if(getQueryValue() == query) return
        _query.postValue(query)
        resetOffset()
        getGifsByQuery(query)
    }

    private val _offsetValue = MutableLiveData<Int>(0)
    val offsetValue: LiveData<Int> = _offsetValue
    private fun getOffsetValue(): Int? = offsetValue.value
    fun resetOffset(){
        _offsetValue.postValue(0)
    }

    private val _listMode = MutableLiveData(ListMode.GRID)
    val listMode: LiveData<ListMode> = _listMode
    fun switchListMode(){
        when(listMode.value){
            ListMode.GRID -> _listMode.postValue(ListMode.LINEAR)
            ListMode.LINEAR -> _listMode.postValue(ListMode.GRID)
            else -> _listMode.postValue(ListMode.LINEAR)
        }
    }

    fun getGifsByQuery(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val response = gifRepository.getGifsFromApi(
                query = query,
                offset = getOffsetValue() ?: 0
            )
            when(response){
                is RetrofitResponse.Error -> {
                    Log.e("logs", "error")
                }
                is RetrofitResponse.Success -> {
                    _gifsList.postValue(response.gifsList)
                }
            }
        }
    }

}