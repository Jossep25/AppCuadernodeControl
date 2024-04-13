package pe.edu.idat.proyectofinal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.idat.proyectofinal.model.ControlRoomDatabase
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.repository.UsuarioRepository

class UsuarioViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: UsuarioRepository
    init {
        val usuarioDao = ControlRoomDatabase.getDatabase(application).usuarioDao()
        repository = UsuarioRepository(usuarioDao)
    }
    fun insertar(usuarioEntity: UsuarioEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertar(usuarioEntity)
    }
    fun actualizar(usuarioEntity: UsuarioEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.actualizar(usuarioEntity)
    }
    fun eliminar() = viewModelScope.launch(Dispatchers.IO){
        repository.eliminarTodo()
    }
    fun obtener(): LiveData<UsuarioEntity> {
        return repository.obtener()
    }
}