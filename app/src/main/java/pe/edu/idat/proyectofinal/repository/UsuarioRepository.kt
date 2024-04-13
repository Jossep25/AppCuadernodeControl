package pe.edu.idat.proyectofinal.repository

import androidx.lifecycle.LiveData
import pe.edu.idat.proyectofinal.model.dao.UsuarioDao
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity

class UsuarioRepository(private val usuarioDao: UsuarioDao) {
    suspend fun insertar(usuarioEntity: UsuarioEntity){
        usuarioDao.insertar(usuarioEntity)
    }
    suspend fun actualizar(usuarioEntity: UsuarioEntity){
        usuarioDao.actualizar(usuarioEntity)
    }
    suspend fun eliminarTodo(){
        usuarioDao.eliminarTodo()
    }
    fun obtener(): LiveData<UsuarioEntity> {
        return usuarioDao.obtener()
    }

}