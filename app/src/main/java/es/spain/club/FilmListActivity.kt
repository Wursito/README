package es.spain.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.FilmListBinding
import javax.inject.Inject


@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter


    private lateinit var binding: FilmListBinding

    private val  viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.adapter = adapter


    viewModel.loadFilms()


    viewModel.films.observe(this){
        adapter.submitList(it)
    }
    adapter.callback={
        Log.i("Hola", "este es el mesanje")

        val intent = Intent (this, FilmActivity::class.java)
        startActivity(intent)
        
    }

    }


}