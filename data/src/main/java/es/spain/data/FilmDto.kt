package es.spain.data

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: Int,
    @SerializedName("Description") val  overview: Int,
    @SerializedName("Rating") val  vote_average: Int,
    @SerializedName("Rating") val  poster_path: Int,




