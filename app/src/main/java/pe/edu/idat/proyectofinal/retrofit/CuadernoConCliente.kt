package pe.edu.idat.proyectofinal.retrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
object CuadernoConCliente {
    private var retrofitCliente = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(15, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES).build()
    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://apiproyectofinal-production.up.railway.app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(retrofitCliente)
        .build()

    val retrofitService: CuadernoConServices by lazy {
        buildRetrofit().create(CuadernoConServices::class.java)
    }
}