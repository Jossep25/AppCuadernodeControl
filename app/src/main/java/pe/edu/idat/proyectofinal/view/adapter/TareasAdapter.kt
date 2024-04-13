package pe.edu.idat.proyectofinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemTareaBinding
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse

class TareasAdapter(private var listaTareas: List<TareasResponse>) : RecyclerView.Adapter<TareasAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemTareaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasAdapter.ViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TareasAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(listaTareas[position]) {
                binding.tvTareaNombreHijo.text = nombre_hijo
                binding.tvTareaCurso.text = curso
                binding.tvTareaFecha.text= fecha
                binding.tvTareaDescripcion.text = descripcion
                binding.tvTareaCategoria.text = nombre_categoria

            }
        }
    }

    override fun getItemCount(): Int = listaTareas.size
}