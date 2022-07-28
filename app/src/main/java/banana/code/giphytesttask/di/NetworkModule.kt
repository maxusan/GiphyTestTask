package banana.code.giphytesttask.di

import android.content.Context
import androidx.room.Room
import banana.code.giphytesttask.data.GifRepository
import banana.code.giphytesttask.data.db.AppDatabase
import banana.code.giphytesttask.data.db.dao.GifDao
import banana.code.giphytesttask.remote.GifRemoteInterface
import banana.code.giphytesttask.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInterface(): GifRemoteInterface {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GifRemoteInterface::class.java)
    }


}