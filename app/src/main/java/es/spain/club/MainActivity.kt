package es.spain.club

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Victor", "Se ha iniciado la aplicacion")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Victor", "Pasa a estado visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Victor", "Sale de estado invisible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Victor", "Se vuelve a iniciar la aplicacion")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Victor", "La aplicacion se ha parado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Victor", "La aplicacion ha dejado de ejercutarse")


    }

}