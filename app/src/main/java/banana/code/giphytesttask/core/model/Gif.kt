package banana.code.giphytesttask.core.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
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

    companion object{
        fun getGifCallback(): DiffUtil.ItemCallback<Gif>{
            return object: DiffUtil.ItemCallback<Gif>(){
                override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
                    return oldItem == newItem
                }

            }
        }
    }

}