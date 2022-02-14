package es.spain.data

import android.icu.text.CaseMap
import android.media.Rating
import database.DatabaseDataSource
import es.spain.domain.entity.Film
import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(


    private val databaseDataSource: DatabaseDataSource,
    private val serverDataSource: ServerDataSource): FilmRepository {
    override suspend fun getfilm(id: Int, language: String): Film? {
        return runCatching {
        serverDataSource.getFilm(id, language)
    }.getOrNull()

    }

    override suspend fun getFilm(id: Int, language: String):Film? {
        return runCatching {
            val filmfromServer = serverDataSource.getFilm(id,language)
            databaseDataSource.updateFilms(listOf(filmfromServer))
            filmfromServer
        }.getOrNull() ?: databaseDataSource.getFilm(id)
    }


    override suspend fun getFilms(language: String): List<Film>? {
        return runCatching {
            val filmsfromServer = serverDataSource.getFilms(language)
            databaseDataSource.updateFilms(filmsfromServer)
            filmsfromServer
        }.getOrNull() ?: databaseDataSource.getFilms()
    }


}