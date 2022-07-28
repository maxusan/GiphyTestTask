package banana.code.giphytesttask.di

import banana.code.giphytesttask.data.GifRepository
import banana.code.giphytesttask.remote.GifRemoteInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGifRepository(gifRemoteInterface: GifRemoteInterface): GifRepository{
        return GifRepository(gifRemoteInterface)
    }

}