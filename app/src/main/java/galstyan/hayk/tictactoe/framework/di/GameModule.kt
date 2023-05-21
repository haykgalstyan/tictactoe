package galstyan.hayk.tictactoe.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import galstyan.hayk.tictactoe.data.GameRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Provides
    @Singleton
    fun provideGameRepository() = GameRepository()
}