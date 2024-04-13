package pe.edu.idat.proyectofinal.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.request.EventosRequest
import pe.edu.idat.proyectofinal.retrofit.response.EventosResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventosRepository {

    var eventosResponse = MutableLiveData<List<EventosResponse>>()
    fun cargarEventos(eventosRequest: EventosRequest): MutableLiveData<List<EventosResponse>>{
        val call : Call<List<EventosResponse>> = CuadernoConCliente.retrofitService.eventos(eventosRequest)
        call.enqueue(object : Callback<List<EventosResponse>> {
            override fun onResponse(
                call: Call<List<EventosResponse>>,
                response: Response<List<EventosResponse>>
            ) {
                if (response.isSuccessful) {
                    val eventos = response.body()
                    if (eventos != null) {
                        eventosResponse.value = eventos.toList()
                    } else {
                        Log.e("EventosResponse", "La lista de eventos es nula")
                    }
                } else {
                    Log.e("EventosResponse", "Error al recibir los eventos: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<EventosResponse>>, t: Throwable) {
                Log.i("ErrorListEventos", t.message.toString())
            }
        })
        return eventosResponse
    }
}