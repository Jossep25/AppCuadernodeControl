package pe.edu.idat.proyectofinal.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}