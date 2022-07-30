package banana.code.giphytesttask.core.model.mapper

import banana.code.giphytesttask.core.data.response.Data
import banana.code.giphytesttask.core.model.Gif
import banana.code.giphytesttask.core.remote.response.GiphyResponse

object GifMapper {
    fun map(response: GiphyResponse): List<Gif> {
        return response.data
            .map { gif -> mapSingle(gif) }
    }

    private fun mapSingle(data: Data): Gif {
        return Gif(
            id = data.id,
            title = data.title,
            link = data.images.original.url,
        )
    }

}