package pe.edu.idat.proyectofinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemTareaBinding
import pe.edu.idat.proyectofinal.retrofit.response.TareasResponse

class TareasAdapter(private var listaTareas: List<TareasResponse>) : RecyclerView.Adapter<TareasAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemTareaBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(tareas: List<TareasResponse>) {
        listaTareas = tareas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listaTareas[position]) {
                binding.txtFecha.text = fecha
                binding.txtTitulo.text = curso
                binding.txtDescripcion.text = descripcion
            }
        }
    }

    override fun getItemCount(): Int = listaTareas.size
}