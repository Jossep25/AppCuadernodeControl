package pe.edu.idat.proyectofinal.view.ui

import android.app.DatePickerDialog
import android.content.Intent
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.ActivityRegistroBinding
import pe.edu.idat.proyectofinal.util.AppMensaje
import pe.edu.idat.proyectofinal.util.TipoMensaje
import pe.edu.idat.proyectofinal.viewmodel.AuthViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegistroActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegistroBinding
    private lateinit var authViewModel: AuthViewModel
    private lateinit var edFecha: TextInputEditText
    private var cal = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.btncancelar.setOnClickListener(this)
        binding.btnregistrar.setOnClickListener(this)

        edFecha = binding.edfecha
        edFecha.setOnClickListener{
            mostrarDatePicker()
        }
        authViewModel.registrarResponse.observe(this, Observer {
                response -> obtenerDatosRegistro(response)
        })
    }

    private fun mostrarDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                actualizarFechaEnEditText()
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )

        // Configuramos el DatePickerDialog para que solo muestre fechas anteriores
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        datePickerDialog.show()
    }

    private fun actualizarFechaEnEditText() {
        val formato = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(formato, Locale.getDefault())
        edFecha.setText(sdf.format(cal.time))
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
            R.id.btncancelar -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
            R.id.btnregistrar -> registrarUsuario()
        }
    }

    private fun registrarUsuario() {
        val telefono = binding.edtelefono.text.toString()
        val dni = binding.edtdni.text.toString()
        val usuario = binding.edtusuario.text.toString()
        val fecha = binding.edfecha.text.toString()
        val email = binding.edtemail.text.toString()
        val password = binding.edtpassword.text.toString()
        if (telefono.isEmpty() || dni.isEmpty() || usuario.isEmpty() || fecha.isEmpty() || email.isEmpty() || password.isEmpty()) {
            AppMensaje.enviarMensaje(binding.root, "Por favor complete todos los campos.", TipoMensaje.ERROR)
            return
        }
        if (telefono.length != 9 || dni.length != 8) {
            AppMensaje.enviarMensaje(binding.root, "El teléfono debe tener 9 dígitos y el DNI 8 dígitos.", TipoMensaje.ERROR)
            return
        }
        binding.btncancelar.isEnabled = false
        binding.btnregistrar.isEnabled = false
        authViewModel.registrar(usuario, dni, fecha, telefono, email, password)
    }
}