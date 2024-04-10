package pe.edu.idat.proyectofinal.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemTareaBinding

class TareasAdapter(private var lista: List<String>) : RecyclerView.Adapter<TareasAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemTareaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewFecha.setText(lista.get(position))
        holder.binding.textViewTitulo.setText(lista.get(position))
        holder.binding.textViewDescripcion.setText(lista.get(position))
    }


}