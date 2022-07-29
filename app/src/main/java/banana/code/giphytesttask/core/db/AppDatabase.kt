package banana.code.giphytesttask.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import banana.code.giphytesttask.core.db.dao.GifDao
import banana.code.giphytesttask.core.model.Gif

@Database(entities = [Gif::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun gifDao(): GifDao
}