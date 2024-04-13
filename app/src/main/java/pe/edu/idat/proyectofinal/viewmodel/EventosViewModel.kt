package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.EventosRepository
import pe.edu.idat.proyectofinal.retrofit.request.EventosRequest
import pe.edu.idat.proyectofinal.retrofit.response.EventosResponse

class EventosViewModel: ViewModel() {
    private  var repository = EventosRepository()

    fun cargarEventos(eventosRequest: EventosRequest): LiveData<List<EventosResponse>> {
        return repository.cargarEventos(eventosRequest)
    }
}