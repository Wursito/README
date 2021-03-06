package es.spain.club

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.spain.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
): ViewModel(), LifecycleObserver {
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val pelicula: LiveData<FilmDataView> = filmLiveData

    fun loadFilm(id: Int) {
        val language = Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilm = useCase.execute(
                id, language
            )
            withContext(Dispatchers.Main) {
                loadedFilm?.let {
                    filmLiveData.value = FilmDataView(
                        it.title,
                        it.description,
                        it.url,
                        it.directorName?:"",
                        it.rating,
                        it.videoId




                    )
                }
            }
        }
    }



    var job: Job? = null
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
