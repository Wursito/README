package es.spain.data

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("Description") val  overview: String,
    @SerializedName("vote_average:") val  Rating: Double,
    @SerializedName("poster_path") val  Portada: String,

)