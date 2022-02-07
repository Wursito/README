package es.spain.data

import dagger.hilt.internal.GeneratedEntryPoint
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "5ea56ed84f1f4dd1deba6e2a8e0da3fa"

interface FilmApi{
    @GET("movie/{id}")
    suspend fun getFilm(@Path("id")filmId:Int,
                        @Query("language")lang:String,
                        @Query("api_key")apiKey:String=API_KEY):FilmDto
    @GET("movie/{id}/credits")
    suspend fun getDirector(@Path ("id")filmID:Int,
                            @Query("api_key")apiKey:String=API_KEY):CreditsDto

    @GET("movie/popular")
    suspend fun getPopular
                (@Query("language") language: String,
                @Query("api_key") apiKey: String= API_KEY): FilmListResultDto

    @GET("movie/{id}/videos")
    suspend fun getVideos(@Path("id") filmId: Int,
                 @Query("language") language: String,
                 @Query("api_key") apiKey: String= API_KEY): VideoResultDto



}

