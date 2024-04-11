package pe.edu.idat.proyectofinal.retrofit

import pe.edu.idat.proyectofinal.retrofit.request.LoginRequest
import pe.edu.idat.proyectofinal.retrofit.request.RegistrarRequest
import pe.edu.idat.proyectofinal.retrofit.response.EventosResponse
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
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
    @GET("api/eventos")
    fun eventos(@Query("idusuario") idusuario: Int):Call<List<EventosResponse>>
}