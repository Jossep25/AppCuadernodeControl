package pe.edu.idat.proyectofinal.retrofit


import pe.edu.idat.proyectofinal.retrofit.request.EventosRequest
import pe.edu.idat.proyectofinal.retrofit.request.LoginRequest
import pe.edu.idat.proyectofinal.retrofit.request.RegistrarRequest
import pe.edu.idat.proyectofinal.retrofit.response.EventosResponse
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.request.ReunionesRequest
import pe.edu.idat.proyectofinal.retrofit.request.TareasRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import pe.edu.idat.proyectofinal.retrofit.response.LoginResponse
import pe.edu.idat.proyectofinal.retrofit.response.RegistrarResponse
import pe.edu.idat.proyectofinal.retrofit.response.ReunionesResponse
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
    fun registrar(@Body registrarRequest: RegistrarRequest): Call<RegistrarResponse>


    @POST("eventos")
    fun eventos(@Body eventosRequest: EventosRequest):Call<List<EventosResponse>>

    @POST("examenes")
    fun examenes(@Body examenesRequest: ExamenesRequest): Call<List<ExamenesResponse>>


    @POST("tareas")
    fun tareas(@Body tareasRequest: TareasRequest): Call<List<TareasResponse>>

    @POST("reuniones")
    fun  reuniones(@Body reunionesRequest: ReunionesRequest):Call<List<ReunionesResponse>>


}