package es.spain.club

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.ActivityMainBinding
import es.spain.domain.usecase.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment : Fragment() {

    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: MyLog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        binding = ActivityMainBinding.inflate(layoutInflater)




        val id = arguments?.getInt(FILM_ID) ?: 512195
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

        }

        return binding.root

    }



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private val  viewModel: MainViewModel by viewModels()

    private fun launchYoutube(id: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
        startActivity(intent)
    }


}