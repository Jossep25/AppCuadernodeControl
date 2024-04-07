package pe.edu.idat.proyectofinal.retrofit.request

data class RegistrarRequest(var nombres: String,
                            var docidentidad: String,
                            var fechanac: String,
                            var telefono: String,
                            var correo: String,
                            var contrasena: String)
