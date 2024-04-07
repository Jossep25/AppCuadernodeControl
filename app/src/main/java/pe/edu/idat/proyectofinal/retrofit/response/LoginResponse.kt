package pe.edu.idat.proyectofinal.retrofit.response

data class LoginResponse(var rpta: Boolean,
                         var idusuario: String,
                         var nombres: String,
                         var docidentidad: String,
                         var correo: String,
                         var fechanac: String,
                         var telefono: String,
                         var contrasena: String,
                         var mensaje: String)
