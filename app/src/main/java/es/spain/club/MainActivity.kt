package es.spain.club

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.ActivityMainBinding
import es.spain.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: MyLog
    @Inject
    lateinit var usecase: GetFilmUseCase


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("Oncreate")
        val film = usecase.execute()
        log.log("El titulo es ${film.title}")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }

    override fun onStart() {
        super.onStart()
        log.log("OnStart")
    }

    override fun onResume() {
        super.onResume()
        binding.title.text = "Hola"
        binding.title.text= resources.getString(R.string.hello)
        log.log("OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        log.log("OnRestart")
    }

    override fun onStop() {
        super.onStop()
        log.log("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.log("OnDestroy")


    }


}