package banana.code.giphytesttask.core.repository

import banana.code.giphytesttask.R
import banana.code.giphytesttask.core.remote.RetrofitResponse
import banana.code.giphytesttask.core.model.mapper.GifMapper
import banana.code.giphytesttask.core.remote.GifRemoteInterface
import banana.code.giphytesttask.core.utils.Constants
import javax.inject.Inject

class GifRepository @Inject constructor(private val gifRemoteInterface: GifRemoteInterface) {
    suspend fun getGifsFromApi(query: String, offset: Int): RetrofitResponse {
        return gifRemoteInterface.getAllGifs(
            apiKey = Constants.API_KEY,
            query = query,
            limit = Constants.QUERY_LIMIT,
            offset = offset
        ).body()?.let {
            if (it.meta.status == 200) {
                RetrofitResponse.Success(GifMapper.map(it), it.pagination)
            } else {
                RetrofitResponse.ErrorCode(it.meta.status)
            }
        } ?: RetrofitResponse.Error(R.string.error)
    }
}