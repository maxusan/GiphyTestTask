package banana.code.giphytesttask.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import banana.code.giphytesttask.core.model.Gif

@Dao
interface GifDao {

    @Query("SELECT * FROM gifs")
    fun getAllGifs(): LiveData<List<Gif>>

    @Insert
    suspend fun insertGif(gif: Gif)

}