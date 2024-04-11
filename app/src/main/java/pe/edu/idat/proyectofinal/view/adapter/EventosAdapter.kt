package pe.edu.idat.proyectofinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.proyectofinal.databinding.ItemEventosBinding
import pe.edu.idat.proyectofinal.retrofit.response.EventosResponse

class EventosAdapter (private var listaEventos:List<EventosResponse>) : RecyclerView.Adapter<EventosAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemEventosBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventosAdapter.ViewHolder {
        val binding = ItemEventosBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventosAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listaEventos[position]){
                binding.tvnombre.text = nombre_hijo
                binding.tvcategoria.text = nombre_categoria
                binding.tvfecha.text = fecha
                binding.tvdescripcion.text = descripcion
                binding.tvcurso.text= curso
            }
        }
    }

    override fun getItemCount(): Int = listaEventos.size
}