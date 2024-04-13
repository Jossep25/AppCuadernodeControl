package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.request.TareasRequest
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TareasRepository {
    val tareasResponse = MutableLiveData<List<TareasResponse>>()

    fun cargarTareas(tareasRequest: TareasRequest): MutableLiveData<List<TareasResponse>> {
        val call: Call<List<TareasResponse>> =
            CuadernoConCliente.retrofitService.tareas(tareasRequest)
        call.enqueue(object : Callback<List<TareasResponse>> {
            override fun onResponse(
                call: Call<List<TareasResponse>>,
                response: Response<List<TareasResponse>>
            ) {
                if (response.isSuccessful) {
                    val tareas = response.body()
                    if (tareas != null) {
                        tareasResponse.value = tareas.toList()
                    } else {
                        Log.e("TareasResponse", "La lista de tareas es nula")
                    }
                } else {
                    Log.e("TareasResponse", "Error al recibir las tareas: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<TareasResponse>>, t: Throwable) {
                Log.e("TareasResponse", "Error al recibir las tareas: ${t.message}", t)
            }


        })
        return tareasResponse
    }
}
