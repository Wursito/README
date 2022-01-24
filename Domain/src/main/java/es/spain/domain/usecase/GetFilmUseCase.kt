package es.spain.domain.usecase

import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val repository : FilmRepository
){
    suspend fun execute (id: Int, language: String) = repository.getfilm(id, language)

}


