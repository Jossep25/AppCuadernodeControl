package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExamenesRepository {
    val examenesResponse = MutableLiveData<List<ExamenesResponse>>()

    fun cargarExamenes(examenesRequest: ExamenesRequest): MutableLiveData<List<ExamenesResponse>> {
        val call: Call<List<ExamenesResponse>> = CuadernoConCliente.retrofitService.examenes(examenesRequest)
        call.enqueue(object : Callback<List<ExamenesResponse>> {
            override fun onResponse(call: Call<List<ExamenesResponse>>, response: Response<List<ExamenesResponse>>) {
                if (response.isSuccessful) {
                    val examenes = response.body()
                    if (examenes != null) {
                        examenesResponse.value = examenes.toList()
                    } else {
                        Log.e("ExamenesResponse", "La lista de exámenes es nula")
                    }
                } else {
                    Log.e("ExamenesResponse", "Error al recibir los exámenes: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ExamenesResponse>>, t: Throwable) {
                Log.e("ExamenesResponse", "Error al recibir los exámenes: ${t.message}", t)
            }
        })
        return examenesResponse
    }

}