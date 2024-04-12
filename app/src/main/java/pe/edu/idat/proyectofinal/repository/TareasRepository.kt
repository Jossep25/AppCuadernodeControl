package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TareasRepository {
    var tareasResponse = MutableLiveData<List<TareasResponse>>()

    fun tareas(): MutableLiveData<List<TareasResponse>>{
        val call: Call<List<TareasResponse>> = CuadernoConCliente.retrofitService.tareas()
        call.enqueue(object : Callback<List<TareasResponse>>{
            override fun onResponse(
                call: Call<List<TareasResponse>>,
                response: Response<List<TareasResponse>>
            ) {
                tareasResponse.value = response.body()
            }

            override fun onFailure(call: Call<List<TareasResponse>>, t: Throwable) {
                Log.i("ErrorListTareas", t.message.toString())
            }

        })
        return tareasResponse
    }

}