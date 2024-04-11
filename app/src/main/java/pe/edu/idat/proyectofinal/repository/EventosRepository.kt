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
    fun eventos(eventosRequest: EventosRequest): MutableLiveData<List<EventosResponse>>{
        val call : Call<List<EventosResponse>> = CuadernoConCliente.retrofitService.eventos(
            eventosRequest.idusuario)
        call.enqueue(object : Callback<List<EventosResponse>> {
            override fun onResponse(
                call: Call<List<EventosResponse>>,
                response: Response<List<EventosResponse>>
            ) {
                eventosResponse.value = response.body()
            }
            override fun onFailure(call: Call<List<EventosResponse>>, t: Throwable) {
                Log.i("ErrorListEventos", t.message.toString())
            }
        })
        return eventosResponse
    }
}