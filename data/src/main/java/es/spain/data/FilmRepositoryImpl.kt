package es.spain.data

import android.icu.text.CaseMap
import android.media.Rating
import es.spain.domain.entity.Film
import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(

private val serverDataSource: ServerDataSource): FilmRepository {
    override suspend fun getfilm(id: Int, language: String): Film? {
        return runCatching {
        serverDataSource.getFilm(id, language)
    }.getOrNull()

    }

    override suspend fun getFilms(language: String): List<Film>? {
        return runCatching {
            serverDataSource.getFilms(language)
        }.getOrNull()
    }



}