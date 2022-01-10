package es.spain.data

import android.icu.text.CaseMap
import android.media.Rating
import es.spain.domain.entity.Film
import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
private val dataSource: HardcodedDataSource): FilmRepository {
override fun getfilm(): Film {
    return dataSource.getfilm()

    }
}