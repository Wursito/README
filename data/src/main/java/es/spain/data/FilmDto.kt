package es.spain.data

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: Int,
    @SerializedName("Description") val  overview: Int,
    @SerializedName("vote_average:") val  Rating: Int,
    @SerializedName("poster_path") val  Portada: Int,

)