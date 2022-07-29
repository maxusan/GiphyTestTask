package banana.code.giphytesttask.core.remote.response

import banana.code.giphytesttask.core.data.response.Data
import banana.code.giphytesttask.core.data.response.Meta
import banana.code.giphytesttask.core.data.response.Pagination

data class GiphyResponse(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)