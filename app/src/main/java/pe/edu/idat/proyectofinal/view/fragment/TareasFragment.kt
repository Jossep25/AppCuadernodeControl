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
import pe.edu.idat.proyectofinal.retrofit.CuadernoConCliente
import pe.edu.idat.proyectofinal.view.adapter.TareasAdapter
import pe.edu.idat.proyectofinal.viewmodel.TareasViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TareasFragment : Fragment() {

   /* private lateinit var tareasViewModel: TareasViewModel
    private lateinit var tareasAdapter: TareasAdapter
    private var _binding: FragmentTareasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTareasBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tareasAdapter = TareasAdapter(emptyList())
        binding.rvtareas.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tareasAdapter
        }
        tareasViewModel = ViewModelProvider(this).get(TareasViewModel::class.java)
        val sharedPref = requireActivity().getSharedPreferences("userData", Context.MODE_PRIVATE)
        val idusuario = sharedPref.getInt("idUsuario", -1)
        if (idusuario != -1) {
            tareasViewModel.listarTareas(idusuario).observe(viewLifecycleOwner) { tareas ->
                tareasAdapter.setData(tareas)
            }
        } else {
            Log.e("TareasFragment", "No se pudo recuperar el ID del usuario")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}