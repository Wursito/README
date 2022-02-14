package es.spain.domain.repository

import es.spain.domain.entity.Film

interface FilmRepository{

    suspend fun getFilm(id: Int, language: String): Film?

    suspend fun getFilms(language: String): List<Film>?
}

