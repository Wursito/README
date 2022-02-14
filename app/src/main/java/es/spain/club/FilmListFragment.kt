package es.spain.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.FilmListBinding
import javax.inject.Inject


@AndroidEntryPoint
class FilmListFragment : Fragment() {

  @Inject
  lateinit var adapter: FilmListAdapter

  private lateinit var binding: FilmListBinding

  private val viewModel: FilmListViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = FilmListBinding.inflate(layoutInflater)
    binding.root.adapter = adapter

    viewModel.loadFilms()

    viewModel.films.observe(this) {
      adapter.submitList(it)
    }

    adapter.callback = {
      Log.i("Hola", "este es el mesanje")

      //TODO


    }


    return binding.root
  }
}