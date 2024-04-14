package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.ReunionesRepository
import pe.edu.idat.proyectofinal.retrofit.request.ReunionesRequest
import pe.edu.idat.proyectofinal.retrofit.response.ReunionesResponse

class ReunionesViewModel :ViewModel(){
    private var repository = ReunionesRepository()

    fun cargarReuniones(reunionesRequest: ReunionesRequest): LiveData<List<ReunionesResponse>>{
        return repository.cargarReuniones(reunionesRequest)
    }
}