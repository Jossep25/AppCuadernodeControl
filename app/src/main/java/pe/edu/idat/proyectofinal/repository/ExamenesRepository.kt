package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExamenesRepository {
    var examenesResponse = MutableLiveData<List<ExamenesResponse>>()

    fun examenes() : MutableLiveData<List<ExamenesResponse>>{
        val call : Call<List<ExamenesResponse>> = CuadernoConCliente.retrofitService.examenes()
        call.enqueue(object : Callback<List<ExamenesResponse>>{
            override fun onResponse(
                call: Call<List<ExamenesResponse>>,
                response: Response<List<ExamenesResponse>>
            ) {
                examenesResponse.value = response.body()
            }

            override fun onFailure(call: Call<List<ExamenesResponse>>, t: Throwable) {
                Log.i("ErrorListExamenes", t.message.toString())
            }

        })
        return examenesResponse
    }

}