package banana.code.giphytesttask.data.model.mapper

import banana.code.giphytesttask.data.model.Gif
import banana.code.giphytesttask.data.response.GiphyResponse

object GifMapper {

    private fun mapSingle(response: GiphyResponse): Gif {
        return Gif(
//            id = response.id,
//            name = response.name,
//            nameEng = response.nameEng,
//            rate = response.rate,
        )
    }

}