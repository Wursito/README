package es.spain.domain.usecase

import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val repository : FilmRepository
){
   fun execute() = repository.getfilm()

}


