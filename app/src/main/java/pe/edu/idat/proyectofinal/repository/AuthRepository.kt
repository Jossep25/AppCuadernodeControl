package pe.edu.idat.proyectofinal.repository

import android.util.Log
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.request.LoginRequest
import pe.edu.idat.proyectofinal.retrofit.request.RegistrarRequest
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    var loginResponse = MutableLiveData<LoginResponse>()
    var registrarResponse = MutableLiveData<RegistrarResponse>()

    fun login(loginRequest: LoginRequest): MutableLiveData<LoginResponse> {
        val call: Call<LoginResponse> = CuadernoConCliente.retrofitService.login(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    loginResponse.value = response.body()
                } else {
                    if (response.code() == 500) {
                        loginResponse.postValue(LoginResponse("Credenciales incorrectas", false))
                    } else {
                        loginResponse.postValue(LoginResponse("Error de conexión", false))
                    }
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return loginResponse
    }
    fun registro(registrarRequest: RegistrarRequest): MutableLiveData<RegistrarResponse>{
        val call: Call<RegistrarResponse> = CuadernoConCliente.retrofitService.registrar(registrarRequest)
        call.enqueue(object : Callback<RegistrarResponse>{
            override fun onResponse(call: Call<RegistrarResponse>, response: Response<RegistrarResponse>) {
                registrarResponse.value = response.body()
            }
            override fun onFailure(call: Call<RegistrarResponse>, t: Throwable) {
                Log.e("ErrorLogin", t.message.toString())
            }
        })
        return registrarResponse
    }
}