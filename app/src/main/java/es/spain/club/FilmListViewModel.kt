package es.spain.club

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


    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}