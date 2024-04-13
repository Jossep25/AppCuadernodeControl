package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.TareasRepository
import pe.edu.idat.proyectofinal.retrofit.request.TareasRequest
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse

class TareasViewModel: ViewModel() {

    private var repository = TareasRepository()

    fun cargarTareas(tareasRequest: TareasRequest): LiveData<List<TareasResponse>>{
        return repository.cargarTareas(tareasRequest)
    }
}