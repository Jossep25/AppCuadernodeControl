package pe.edu.idat.proyectofinal.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemExamenesBinding

class ExamenesAdapter(private var lista: List<String>) : RecyclerView.Adapter<ExamenesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemExamenesBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExamenesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewFecha.setText(lista.get(position))
        holder.binding.textViewCursoExamen.setText(lista.get(position))
    }


}