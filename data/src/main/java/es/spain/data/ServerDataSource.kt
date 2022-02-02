package es.spain.data

import es.spain.domain.entity.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Inject

const val BASE_URL = "https://api.themoviedb.org/3/"

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: FilmApi = retrofit.create(FilmApi::class.java)

    suspend fun getFilm(id: Int, language: String): Film {
        val filmDto = api.getFilm(id, language)
        val creditsDto = api.getDirector(id)
        val director = creditsDto.Role.firstOrNull { it.Role == "Directing" }?.Name ?: ""
        val image = "https://image.tmdb.org/t/p/w500${filmDto.Portada}"
        return Film(filmDto.title, image, filmDto.Rating, director, filmDto.overview, filmDto.id)

    }

    suspend fun getFilms(language: String):  List<Film> {
        return api.getPopular(language).films.map {
            val image = "https://image.tmdb.org/t/p/w500${it.Portada}"
            Film(it.title, image, it.Rating, null , it.overview, it.id)
        }
    }

}
