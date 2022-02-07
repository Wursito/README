package es.spain.data

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast") val Role: List<CastDto>

)
