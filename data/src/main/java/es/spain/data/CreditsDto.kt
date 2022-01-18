package es.spain.data

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("Cast") val Role: List<CastDto>

)
