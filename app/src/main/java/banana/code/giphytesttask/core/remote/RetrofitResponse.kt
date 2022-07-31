package banana.code.giphytesttask.core.remote

import banana.code.giphytesttask.core.data.response.Pagination
import banana.code.giphytesttask.core.model.Gif

sealed class RetrofitResponse{
    data class Success(val gifsList: List<Gif>, val pagination: Pagination): RetrofitResponse()
    data class Error(var errorMessage: Int) : RetrofitResponse()
    data class ErrorCode(var errorCode: Int) : RetrofitResponse()
}
