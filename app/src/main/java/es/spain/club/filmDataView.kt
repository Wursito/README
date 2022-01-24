package es.spain.club

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class FilmDataView(
    val title:String,
    val description:String,
    val url:String,
    val directorName: String,
    val Rating:Double)
