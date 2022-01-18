package es.spain.club

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.spain.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@HiltViewModel

data class  FilmDataView(val title: String)
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
): ViewModel(), LifecycleObserver {
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val pelicula: LiveData<FilmDataView> = filmLiveData

    fun loadFilm() {
        val loadedFilm = useCase.execute()
        filmLiveData.value = FilmDataView(loadedFilm.title)
    }
}