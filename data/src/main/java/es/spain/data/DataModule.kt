package es.spain.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import database.RoomModule
import es.spain.domain.repository.FilmRepository

@Module (includes = [RoomModule::class])
@InstallIn(ActivityComponent::class)

abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}