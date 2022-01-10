package es.spain.domain.repository

import es.spain.domain.entity.Film

interface FilmRepository{


    fun getfilm(): Film
}

