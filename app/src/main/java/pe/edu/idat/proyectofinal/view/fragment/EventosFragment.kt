package pe.edu.idat.proyectofinal.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Entity
import pe.edu.idat.proyectofinal.databinding.FragmentEventosBinding
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.retrofit.request.EventosRequest

import pe.edu.idat.proyectofinal.view.adapter.EventosAdapter
import pe.edu.idat.proyectofinal.viewmodel.EventosViewModel
import pe.edu.idat.proyectofinal.viewmodel.UsuarioViewModel

class EventosFragment : Fragment() {
    private  var _binding: FragmentEventosBinding? = null
    private  val binding get() = _binding!!
    private lateinit var eventosViewModel: EventosViewModel
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEntity: UsuarioEntity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventosBinding.inflate(inflater, container, false)
        binding.rvevento.layoutManager = LinearLayoutManager(requireActivity())

        eventosViewModel = ViewModelProvider(requireActivity()).get(EventosViewModel::class.java)
        usuarioViewModel = ViewModelProvider(requireActivity()).get(UsuarioViewModel::class.java)
        usuarioViewModel.obtener().observe(viewLifecycleOwner, Observer { persona ->
            persona?.let { listarEvento(persona.id) }

        })
        return binding.root
    }

    private fun listarEvento(idUsuario: Int) {
        val eventosRequest = EventosRequest(idUsuario)
        eventosViewModel.cargarEventos(eventosRequest).observe(viewLifecycleOwner, Observer {
            binding.rvevento.adapter = EventosAdapter(it)
        })
    }


}