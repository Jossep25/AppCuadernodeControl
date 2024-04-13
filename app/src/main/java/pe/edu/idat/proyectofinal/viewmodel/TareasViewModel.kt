package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.TareasRepository
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse

class TareasViewModel: ViewModel() {

    private var repository = TareasRepository()

    fun listarTareas(): LiveData<List<TareasResponse>>{
        return repository.tareas()
    }
}