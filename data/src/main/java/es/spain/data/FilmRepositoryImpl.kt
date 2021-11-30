package es.spain.data

import android.icu.text.CaseMap
import android.media.Rating
import es.spain.domain.entity.Film
import es.spain.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(): FilmRepository {
override fun getfilm(): Film {
    return Film(
        title = "FastAndFurious",
        url = "www.Tofasttofurious.com",
        rating = 10.0,
        directorName = "Michael Jack"

        )
    }
}