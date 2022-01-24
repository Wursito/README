package es.spain.club

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.ActivityMainBinding
import es.spain.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: MyLog



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("Oncreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadFilm(512195)
        viewModel.pelicula.observe(this){

            binding.textView2.text = it.title
            binding.textView.text = it.description
            binding.textviewMovieDetails.text = it.directorName
            binding.rating.rating = it.Rating.toFloat()
            Glide.with(this).load(it.url).into(binding.imageView)
        }




    }

    private val  viewModel: MainViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        log.log("OnStart")
    }

    override fun onResume() {
        super.onResume()
        binding.textView.text= "Victor empieza estado foreground"
        binding.imageView.setImageResource(R.drawable.ic_launcher_background)
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