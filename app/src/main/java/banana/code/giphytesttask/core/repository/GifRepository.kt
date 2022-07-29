package banana.code.giphytesttask.core.repository

import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.core.model.RetrofitResponse
import banana.code.giphytesttask.core.model.mapper.GifMapper
import banana.code.giphytesttask.core.remote.GifRemoteInterface
import banana.code.giphytesttask.core.utils.Constants
import javax.inject.Inject

class GifRepository @Inject constructor(val gifRemoteInterface: GifRemoteInterface) {
    suspend fun getGifsFromApi(query: String, offset: Int): RetrofitResponse {
        return gifRemoteInterface.getAllGifs(
            apiKey = Constants.API_KEY,
            query = query,
            limit = 25,
            offset = offset
        ).body()?.let {
            RetrofitResponse.Success(GifMapper.map(it))
        } ?: RetrofitResponse.Error(R.string.error)
    }
}