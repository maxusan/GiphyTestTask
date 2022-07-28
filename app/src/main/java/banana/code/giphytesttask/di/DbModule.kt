package banana.code.giphytesttask.di

import android.content.Context
import androidx.room.Room
import banana.code.giphytesttask.data.db.AppDatabase
import banana.code.giphytesttask.data.db.dao.GifDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room
            .databaseBuilder(appContext,
                AppDatabase::class.java,
                "app_database")
            .build()
    }

    @Provides
    fun provideGifDao(appDatabase: AppDatabase): GifDao {
        return appDatabase.gifDao()
    }
}