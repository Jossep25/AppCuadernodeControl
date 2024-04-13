package pe.edu.idat.proyectofinal.view.fragment

import android.os.Bundle
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
import pe.edu.idat.proyectofinal.view.adapter.TareasAdapter
import pe.edu.idat.proyectofinal.viewmodel.TareasViewModel

class TareasFragment : Fragment() {

    private var _binding: FragmentTareasBinding? = null

    private val binding get() = _binding!!

    private lateinit var tareasViewModel: TareasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTareasBinding.inflate(inflater,container,false)
        binding.rvtareas.layoutManager = LinearLayoutManager(requireActivity())
        tareasViewModel = ViewModelProvider(requireActivity()).get(TareasViewModel::class.java)
        listarTareas()
        return binding.root
    }

    private fun listarTareas(){
        tareasViewModel.listarTareas().observe(viewLifecycleOwner,
            Observer {
                binding.rvtareas.adapter = TareasAdapter(it)

        })
    }


}