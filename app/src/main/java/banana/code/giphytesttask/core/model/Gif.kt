package banana.code.giphytesttask.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gifs")
data class Gif(
    @PrimaryKey
    var id: String = "",
    var title: String = "",
    var link: String = ""
) {
}