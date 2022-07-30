package banana.code.giphytesttask.core.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "gifs")
@Parcelize
data class Gif(
    @PrimaryKey
    var id: String = "",
    var title: String = "",
    var link: String = ""
): Parcelable {



}