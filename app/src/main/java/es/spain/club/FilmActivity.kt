package es.spain.club

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.ActivityMainBinding
import es.spain.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: MyLog



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("Oncreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val id = intent?.extras?.getInt(FILM_ID) ?: 512195
        viewModel.loadFilm(id)


        viewModel.pelicula.observe(this){

            binding.titulo.text = it.title
            binding.textView.text = it.description
            binding.director.text = it.directorName
            binding.rating.rating = it.Rating.toFloat()
            Glide.with(this).load(it.url).into(binding.imageView)

        if (it.videoId == null) {
            binding.buttonRent.visibility = View.INVISIBLE
        } else {
            binding.buttonRent.visibility = View.VISIBLE
            binding.buttonRent.setOnClickListener{ d->
                launchYoutube(it.videoId)
            }

        }

        actionBar?.setDisplayHomeAsUpEnabled(true)
        }





    }

    private val  viewModel: MainViewModel by viewModels()

    private fun launchYoutube(id: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
        startActivity(intent)
    }




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