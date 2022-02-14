package es.spain.club

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import es.spain.club.databinding.MainBinding


@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding= MainBinding.inflate(layoutInflater)
        setContentView((binding.root))
    }


}