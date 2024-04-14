package pe.edu.idat.proyectofinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemExamenesBinding
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse

class ExamenesAdapter(private var listaExamenes: List<ExamenesResponse>) : RecyclerView.Adapter<ExamenesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemExamenesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenesAdapter.ViewHolder {
        val binding = ItemExamenesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExamenesAdapter.ViewHolder , position: Int) {

        with(holder){
            with(listaExamenes[position]){
                binding.tvExamenNombreHijo.text = nombre_hijo
                binding.tvExamenCurso.text = curso
                binding.tvExamenFecha.text = fecha
                binding.tvExamenDescripcion.text = descripcion
                binding.tvExamenCategoria.text = nombre_categoria

            }
        }
    }

    override fun getItemCount() : Int = listaExamenes.size


}