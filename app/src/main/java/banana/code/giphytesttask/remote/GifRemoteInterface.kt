package banana.code.giphytesttask.remote

import banana.code.giphytesttask.data.response.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifRemoteInterface {

    @GET("search?")
    suspend fun getAllGifs(
        @Query("api_key")apiKey: String,
        @Query("q")query: String,
        @Query("limit")limit: Int,
//        @Query("offset")offset: Int
    ): Response<GiphyResponse>

}