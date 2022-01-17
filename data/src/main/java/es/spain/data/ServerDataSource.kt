package es.spain.data

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

    suspend fun getFilm(id: Int, language: String): Film{
        val filmDto = api.getFilm(id, language)
    }
}