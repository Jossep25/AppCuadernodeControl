package pe.edu.idat.proyectofinal.view.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.ActivityMainBinding
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.util.AppMensaje
import pe.edu.idat.proyectofinal.util.SharedPreferencesManager
import pe.edu.idat.proyectofinal.util.TipoMensaje
import pe.edu.idat.proyectofinal.viewmodel.AuthViewModel
import pe.edu.idat.proyectofinal.viewmodel.UsuarioViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var authViewModel: AuthViewModel
    private lateinit var usuarioViewModel: UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        binding.btnlogin.setOnClickListener(this)
        binding.btnregistro.setOnClickListener(this)
        authViewModel.loginResponse.observe(this, Observer {
                response -> obtenerDatosLogin(response)
        })
    }
    private fun obtenerDatosLogin(response: LoginResponse) {
        if(response.rpta){
            val usuarioEntity = UsuarioEntity(
                response.idusuario.toInt(), response.nombres, response.docidentidad,
                response.fechanac, response.telefono, response.correo, response.contrasena)
            if(recordarDatosLogin()){
                usuarioViewModel.actualizar(usuarioEntity)
            }else{
                usuarioViewModel.insertar(usuarioEntity)
                if(binding.cbRecordarUsuario.isChecked){
                    SharedPreferencesManager().setValorBoolean("PREF_RECORDAR",
                        true)
                }
            }
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }else{
            AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ERROR)
        }
        binding.btnlogin.isEnabled = true
        binding.btnregistro.isEnabled = true
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btnlogin -> autenticarUsuario()
            R.id.btnregistro -> startActivity(Intent(applicationContext, RegistroActivity::class.java))
            R.id.cbRecordarUsuario ->recordarDatos(v)
        }
    }

    private fun recordarDatos(vista: View) {
        if (vista is CheckBox) {
            val checkeo = vista.isChecked
            if (!checkeo) {
                if (recordarDatosLogin()) {
                    SharedPreferencesManager().eliminarPreferencia("PREF_RECORDAR")
                    usuarioViewModel.eliminar()
                    binding.edtemail.isEnabled = true
                    binding.edtpassword.isEnabled = true
                    binding.cbRecordarUsuario.text = getString(R.string.rscbRecordarUsuario)
                }
            }
        }
    }
    private fun autenticarUsuario() {
        binding.btnlogin.isEnabled = false
        binding.btnregistro.isEnabled = false
        authViewModel.login(
            binding.edtemail.text.toString(),
            binding.edtpassword.text.toString()
        )
    }

    private fun recordarDatosLogin(): Boolean {
        return SharedPreferencesManager().getValorBoolean("PREF_RECORDAR")
    }
}

