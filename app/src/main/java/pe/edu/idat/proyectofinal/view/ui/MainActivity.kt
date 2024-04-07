package pe.edu.idat.proyectofinal.view.ui

import androidx.lifecycle.Observer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.ActivityMainBinding
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.util.AppMensaje
import pe.edu.idat.proyectofinal.util.Noti
import pe.edu.idat.proyectofinal.viewmodel.AuthViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.btnlogin.setOnClickListener(this)
        binding.btnregistro.setOnClickListener(this)
        authViewModel.loginResponse.observe(this, Observer {
                response -> obtenerDatosLogin(response)
        })
    }
    private fun obtenerDatosLogin(response: LoginResponse) {
        if(response.rpta){
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }else{
            AppMensaje.enviarMensaje(binding.root, response.mensaje, Noti.ERROR)
        }
        binding.btnlogin.isEnabled = true
        binding.btnregistro.isEnabled = true
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btnlogin -> autenticarUsuario()
            R.id.btnregistro -> startActivity(Intent(applicationContext, RegistroActivity::class.java))
        }
    }
    private fun autenticarUsuario() {
        binding.btnlogin.isEnabled = false
        binding.btnregistro.isEnabled = false
        authViewModel.login(binding.edtemail.text.toString(),
            binding.edtpassword.text.toString())
    }
}