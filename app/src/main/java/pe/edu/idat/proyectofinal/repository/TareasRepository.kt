package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TareasRepository {
    /*fun tareas(idusuario: Int): MutableLiveData<List<TareasResponse>> {
        val call: Call<List<TareasResponse>> = CuadernoConCliente.retrofitService.tareas(idusuario)
        val tareasResponse = MutableLiveData<List<TareasResponse>>()
        call.enqueue(object : Callback<List<TareasResponse>> {
            override fun onResponse(call: Call<List<TareasResponse>>, response: Response<List<TareasResponse>>) {
                if (response.isSuccessful) {
                    val tareas = response.body()
                    Log.d("TareasRepository", "Respuesta exitosa: $tareas")
                    tareasResponse.value = tareas ?: emptyList()
                } else {
                    Log.e("TareasRepository", "Error en la respuesta: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<TareasResponse>>, t: Throwable) {
                Log.i("ErrorListTareas", t.message.toString())
            }
        })
        return tareasResponse
    }*/
}
