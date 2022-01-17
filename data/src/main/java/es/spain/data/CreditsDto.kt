package es.spain.data

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("known_for_department") val Role: String,
    @SerializedName("original_name") val Name: String,
)
