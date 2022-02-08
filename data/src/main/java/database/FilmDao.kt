package database

import androidx.room.*
import es.spain.domain.entity.Film
import java.sql.RowId


@Dao
interface FilmDao {

    @Query("SELECT * from FilmEntity")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * from FilmEntity WHERE id LIKE :FilmId")
    suspend fun getFilm(FilmId: Int): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films:List<FilmEntity>)

    @Delete
    suspend fun deleteFilm(film: Film)

    @Query("DELETE from FilmEntity")
    suspend fun deleteAll()
}