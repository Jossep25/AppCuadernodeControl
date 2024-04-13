package pe.edu.idat.proyectofinal.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity (
    @PrimaryKey
    var id:Int,
    var nombres:String,
    var docidentidad:String,
    var fechanac:String,
    var telefono:String,
    var correo:String,
    var contrasena:String
)