package banana.code.giphytesttask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gifs")
data class Gif(
    @PrimaryKey(autoGenerate = true)
    var i: Int = 0
) {
}