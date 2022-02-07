package es.spain.data

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_department") val Role: String,
    @SerializedName("name") val Name: String,
)