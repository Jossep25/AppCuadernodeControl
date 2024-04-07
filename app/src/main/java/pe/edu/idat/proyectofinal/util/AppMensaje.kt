package pe.edu.idat.proyectofinal.util

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import pe.edu.idat.proyectofinal.R

object AppMensaje {
    fun enviarMensaje(vista: View, mensaje: String, tipo: Noti){
        val snackBar = Snackbar.make(vista, mensaje, Snackbar.LENGTH_LONG)
        when(tipo){
            Noti.ERROR-> snackBar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia, R.color.error))
            Noti.CORRECTO-> snackBar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia, R.color.correcto))
            Noti.ADVERTENCIA-> snackBar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia, R.color.advertencia))
            Noti.INFORMACION-> snackBar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia, R.color.info))
        }
        snackBar.show()
    }
}