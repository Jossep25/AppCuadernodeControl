package pe.edu.idat.proyectofinal.retrofit

import pe.edu.idat.proyectofinal.retrofit.request.LoginRequest
import pe.edu.idat.proyectofinal.retrofit.request.RegistrarRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface CuadernoConServices {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
    @POST("usuario")
    fun register(@Body registrarRequest: RegistrarRequest): Call<RegistrarResponse>

    fun examenes(@Query("usuarioId") idusuario: String): Call<List<ExamenesResponse>>


    @GET("tareas")
    fun tareas(): Call<List<TareasResponse>>

}