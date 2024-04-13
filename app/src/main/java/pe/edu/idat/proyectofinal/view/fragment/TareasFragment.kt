package pe.edu.idat.proyectofinal.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.proyectofinal.R
import pe.edu.idat.proyectofinal.databinding.FragmentTareasBinding
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.retrofit.request.TareasRequest
import pe.edu.idat.proyectofinal.view.adapter.TareasAdapter
import pe.edu.idat.proyectofinal.viewmodel.TareasViewModel
import pe.edu.idat.proyectofinal.viewmodel.UsuarioViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TareasFragment : Fragment() {

    private var idusuario = 0
    private var _binding: FragmentTareasBinding? = null
    private val binding get() = _binding!!
    private lateinit var tareasViewModel: TareasViewModel
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var usuarioEntity: UsuarioEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTareasBinding.inflate(inflater, container, false)
        binding.rvtareas.layoutManager = LinearLayoutManager(requireActivity())

        tareasViewModel = ViewModelProvider(requireActivity()).get(TareasViewModel::class.java)
        usuarioViewModel = ViewModelProvider(requireActivity()).get(UsuarioViewModel::class.java)
        usuarioViewModel.obtener().observe(viewLifecycleOwner, Observer { persona ->
            persona?.let {
                listarTarea(persona.id)
            }
        })
        return binding.root
    }
    private fun listarTarea(idusuario:Int){
        val tareasRequest = TareasRequest(idusuario)
        tareasViewModel.cargarTareas(tareasRequest).observe(viewLifecycleOwner, Observer {
            binding.rvtareas.adapter = TareasAdapter(it)
        })
    }

}