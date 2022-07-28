package banana.code.giphytesttask.data

import banana.code.giphytesttask.remote.GifRemoteInterface
import dagger.Binds
import javax.inject.Inject

class GifRepository @Inject constructor(val gifRemoteInterface: GifRemoteInterface) {
    suspend fun getGifsFromApi(){
//        gifRemoteInterface.getAllGifs(
//
//        )
    }
}