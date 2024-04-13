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
                binding.tvEventoNombre.text = nombre_hijo
                binding.tvEventosCurso.text = nombre_categoria
                binding.tvEventoFecha.text = fecha
                binding.tvEventoDescripcion.text = descripcion
                binding.tvEventoCategoria.text= curso
            }
        }
    }

    override fun getItemCount(): Int = listaEventos.size
}