package database

import es.spain.domain.entity.Film
import javax.inject.Inject

class DatabaseDataSource @Inject constructor(
    private val database: AppDatabase
) {


    suspend fun getFilms(): List<Film> {
       return database.filmDao().getFilms().map{it.toDomain()}
    }

    suspend fun getFilm(id: Int): Film? {
        return database.filmDao().getFilm(id)?.toDomain()
    }

    suspend fun clearFilms(){
        database.filmDao().deleteAll()
    }

    private fun FilmEntity.toDomain(): Film=
        Film(
        title,
        url,
        rating,
        directorName,
        description,
        id,
        videoId
        )

    suspend fun updateFilms(films: List<Film>){
        database.filmDao().insertAll(films.map { it.toEntity()})
    }

    private fun Film.toEntity(): FilmEntity=
        FilmEntity(
            title,
            url,
            rating,
            directorName,
            description,
            id,
            videoId

        )

}