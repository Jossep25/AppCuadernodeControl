package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.request.ReunionesRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import pe.edu.idat.proyectofinal.retrofit.response.ReunionesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReunionesRepository {
    val reunionesResponse = MutableLiveData<List<ReunionesResponse>>()

    fun cargarReuniones(reunionesRequest: ReunionesRequest): MutableLiveData<List<ReunionesResponse>> {
        val call: Call<List<ReunionesResponse>> = CuadernoConCliente.retrofitService.reuniones(reunionesRequest)
        call.enqueue(object : Callback<List<ReunionesResponse>> {
            override fun onResponse(call: Call<List<ReunionesResponse>>, response: Response<List<ReunionesResponse>>) {
                if (response.isSuccessful) {
                    val reuniones = response.body()
                    if (reuniones != null) {
                        reunionesResponse.value = reuniones.toList()
                    } else {
                        Log.e("ReunionesResponse", "La lista de reuniones es nula")
                    }
                } else {
                    Log.e("ReunionesResponse", "Error al recibir los reuniones: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ReunionesResponse>>, t: Throwable) {
                Log.e("ReunionesResponse", "Error al recibir los reuniones: ${t.message}", t)
            }
        })
        return reunionesResponse
    }
}