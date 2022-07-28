package banana.code.giphytesttask.di

import banana.code.giphytesttask.remote.GifRemoteInterface
import banana.code.giphytesttask.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    @Named("retrofit")
    fun provideRetrofitInterface(): GifRemoteInterface {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GifRemoteInterface::class.java)
    }
}