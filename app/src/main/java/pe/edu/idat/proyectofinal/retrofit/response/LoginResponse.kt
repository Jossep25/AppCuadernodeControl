package pe.edu.idat.proyectofinal.retrofit.response

data class LoginResponse(
    var mensaje: String,
    var rpta: Boolean,
    var idusuario: Int = 0,
    var nombres: String = "",
    var docidentidad: String = "",
    var correo: String = "",
    var fechanac: String = "",
    var telefono: String = "",
    var contrasena: String = ""
) {
    constructor(mensaje: String, rpta: Boolean) : this(mensaje, rpta, 0)
}