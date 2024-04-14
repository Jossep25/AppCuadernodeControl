package pe.edu.idat.proyectofinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemExamenesBinding
import pe.edu.idat.proyectofinal.databinding.ItemReunionBinding
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import pe.edu.idat.proyectofinal.retrofit.response.ReunionesResponse

class ReunionesAdapter (private var listaReuniones: List<ReunionesResponse>) : RecyclerView.Adapter<ReunionesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemReunionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReunionesAdapter.ViewHolder {
        val binding = ItemReunionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReunionesAdapter.ViewHolder, position: Int) {

        with(holder){
            with(listaReuniones[position]){
                binding.tvReunionNombreHijo.text = nombre_hijo
                binding.tvEventoCurso.text = curso
                binding.tvReunionFecha.text = fecha
                binding.tvReunionDescripcion.text = descripcion
                binding.tvReunionCategoria.text = nombre_categoria

            }
        }
    }

    override fun getItemCount() : Int = listaReuniones.size
}