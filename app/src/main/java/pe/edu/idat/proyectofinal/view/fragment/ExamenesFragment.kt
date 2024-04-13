package pe.edu.idat.proyectofinal.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.proyectofinal.databinding.FragmentExamenesBinding
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.retrofit.request.ExamenesRequest
import pe.edu.idat.proyectofinal.retrofit.response.ExamenesResponse
import pe.edu.idat.proyectofinal.view.adapter.ExamenesAdapter
import pe.edu.idat.proyectofinal.viewmodel.ExamenesViewModel
import pe.edu.idat.proyectofinal.viewmodel.UsuarioViewModel

class ExamenesFragment : Fragment() {
    private var idusuario = 0
    private var _binding: FragmentExamenesBinding? = null
    private val binding get() = _binding!!
    private lateinit var examenesViewModel: ExamenesViewModel
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEntity: UsuarioEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExamenesBinding.inflate(inflater, container, false)
        binding.rvexamenes.layoutManager = LinearLayoutManager(requireActivity())

        examenesViewModel = ViewModelProvider(requireActivity()).get(ExamenesViewModel::class.java)
        usuarioViewModel = ViewModelProvider(requireActivity()).get(UsuarioViewModel::class.java)
        usuarioViewModel.obtener().observe(viewLifecycleOwner, Observer { persona ->
            persona?.let {
                listarExamen(persona.id)
            }
        })
        return binding.root
    }

    private fun listarExamen(idusuario: Int) {
        val examenesRequest = ExamenesRequest(idusuario)
        examenesViewModel.cargarExamenes(examenesRequest).observe(viewLifecycleOwner, Observer {
            binding.rvexamenes.adapter = ExamenesAdapter(it)
        })
    }


}