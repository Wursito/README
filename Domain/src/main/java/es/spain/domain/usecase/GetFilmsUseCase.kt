package es.spain.domain.usecase

import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor (
    private val repository : FilmRepository
        ){

    suspend fun execute(language: String) = repository.getFilms(language)

}