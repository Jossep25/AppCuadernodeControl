package pe.edu.idat.proyectofinal.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.FragmentExamenesBinding
import pe.edu.idat.proyectofinal.databinding.FragmentReunionBinding
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.request.ReunionesRequest
import pe.edu.idat.proyectofinal.view.adapter.ExamenesAdapter
import pe.edu.idat.proyectofinal.view.adapter.ReunionesAdapter
import pe.edu.idat.proyectofinal.viewmodel.ExamenesViewModel
import pe.edu.idat.proyectofinal.viewmodel.ReunionesViewModel
import pe.edu.idat.proyectofinal.viewmodel.UsuarioViewModel

class ReunionFragment : Fragment() {
    private var _binding: FragmentReunionBinding? = null
    private val binding get() = _binding!!
    private lateinit var reunionesViewModel: ReunionesViewModel
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEntity: UsuarioEntity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReunionBinding.inflate(inflater, container, false)
        binding.rvreunion.layoutManager = LinearLayoutManager(requireActivity())

        reunionesViewModel = ViewModelProvider(requireActivity()).get(ReunionesViewModel::class.java)
        usuarioViewModel = ViewModelProvider(requireActivity()).get(UsuarioViewModel::class.java)
        usuarioViewModel.obtener().observe(viewLifecycleOwner, Observer { persona ->
            persona?.let {
                listarReunion(persona.id)
            }
        })
        return binding.root
    }
    private fun listarReunion(idusuario: Int) {
        val reunionesRequest = ReunionesRequest(idusuario)
        reunionesViewModel.cargarReuniones(reunionesRequest).observe(viewLifecycleOwner, Observer {
            binding.rvreunion.adapter = ReunionesAdapter(it)
        })
    }

}