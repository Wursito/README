package es.spain.club

import android.os.AsyncTask.execute
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.spain.domain.usecase.GetFilmUseCase
import es.spain.domain.usecase.GetFilmsUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel

class FilmListViewModel @Inject constructor(
 private val useCase: GetFilmsUseCase
):ViewModel(), LifecycleObserver{

    private val filmsLiveData = MutableLiveData<List<FilmOverviewDataView>>()
    val films: LiveData<List<FilmOverviewDataView>> = filmsLiveData
    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun loadFilms(){
        val language= Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilms= useCase.execute(language)
            withContext(Dispatchers.Main){
                loadedFilms?.let {
                    filmsLiveData.value = it.map {
                        film -> FilmOverviewDataView(film.id, film.title, film.url)
                    }
                }
            }
        }
    }



}