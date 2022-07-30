package banana.code.giphytesttask.core.model

import banana.code.giphytesttask.core.data.response.Pagination
import banana.code.giphytesttask.core.remote.response.GiphyResponse

sealed class RetrofitResponse{
    data class Success(val gifsList: List<Gif>, val pagination: Pagination): RetrofitResponse()
    data class Error(var errorMessage: Int): RetrofitResponse()
}
