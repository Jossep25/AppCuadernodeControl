package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.AuthRepository
import pe.edu.idat.proyectofinal.retrofit.request.LoginRequest
import pe.edu.idat.proyectofinal.retrofit.request.RegistrarRequest
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
class AuthViewModel : ViewModel(){
    var loginResponse: LiveData<LoginResponse>
    var registrarResponse: LiveData<RegistrarResponse>
    private var repository = AuthRepository()
    init {
        loginResponse = repository.loginResponse
        registrarResponse = repository.registrarResponse
    }
    fun login (docidentidad: String, contrasena: String){
        loginResponse = repository.login(LoginRequest(docidentidad, contrasena))
    }
    fun registrar(nombres: String,
                  docidentidad: String,
                  fechanac: String,
                  telefono: String,
                  correo: String,
                  contrasena: String){
        registrarResponse = repository.registro(RegistrarRequest(nombres, docidentidad, fechanac, telefono, correo, contrasena))
    }
}