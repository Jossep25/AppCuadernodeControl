package pe.edu.idat.proyectofinal.retrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
object CuardernoConCliente {
    private var retrofitCliente = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(15, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES).build()
    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://apiproyectofinal-production.up.railway.app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(retrofitCliente)
        .build()

    val retrofitService: CuardernoConServices by lazy {
        buildRetrofit().create(CuardernoConServices::class.java)
    }
}