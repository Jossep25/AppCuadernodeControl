package pe.edu.idat.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.proyectofinal.repository.ExamenesRepository
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse

class ExamenesViewModel: ViewModel() {
    private var repository = ExamenesRepository()

    fun cargarExamenes(examenesRequest: ExamenesRequest): LiveData<List<ExamenesResponse>>{

        return repository.cargarExamenes(examenesRequest)
    }





}