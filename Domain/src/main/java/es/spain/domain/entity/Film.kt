package es.spain.domain.entity

data class Film(
    val title: String,
    val url: String,
    val rating: Double,
    val directorName: String?,
    val description: String,
    val id: Int,
    val videoId: String?
)

