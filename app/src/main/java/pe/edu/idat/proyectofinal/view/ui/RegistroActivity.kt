package pe.edu.idat.proyectofinal.view.ui

import android.content.Intent
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.ActivityRegistroBinding
import pe.edu.idat.proyectofinal.viewmodel.AuthViewModel

class RegistroActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegistroBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.btncancelar.setOnClickListener(this)
        binding.btnregistrar.setOnClickListener(this)
        authViewModel.registrarResponse.observe(this, Observer {
                response -> obtenerDatosRegistro(response)
        })
    }
    private fun obtenerDatosRegistro(response: RegistrarResponse) {
        binding.btncancelar.isEnabled = true
        binding.btnregistrar.isEnabled = true
        val mensaje = "Usuario registrado!"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Usuario registrado!", mensaje)
        startActivity(intent)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btncancelar -> startActivity(Intent(applicationContext, MainActivity::class.java))
            R.id.btnregistrar -> registrarUsuario()
        }
    }

    private fun registrarUsuario() {
        val telefono = binding.edtelefono.text.toString()
        val dni = binding.edtdni.text.toString()
        if (telefono.length == 9 && dni.length == 8) {
            binding.btncancelar.isEnabled = false
            binding.btnregistrar.isEnabled = false
            authViewModel.registrar(
                binding.edtusuario.text.toString(),
                dni,
                binding.edfecha.text.toString(),
                telefono,
                binding.edtemail.text.toString(),
                binding.edtpassword.text.toString()
            )
        }
    }
}