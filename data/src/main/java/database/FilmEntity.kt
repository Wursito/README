package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FilmEntity(

    @ColumnInfo (name="title") val title: String,
    @ColumnInfo (name="url")  val url: String,
    @ColumnInfo (name="rating") val rating: Double,
    @ColumnInfo (name="director") val directorName: String?,
    @ColumnInfo (name="description") val description: String,
    @PrimaryKey val id: Int,
    @ColumnInfo (name="videoId") val videoId: String?

    )

