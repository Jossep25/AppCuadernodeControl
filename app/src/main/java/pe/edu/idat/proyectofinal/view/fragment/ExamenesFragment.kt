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
import pe.edu.idat.proyectofinal.view.adapter.ExamenesAdapter
import pe.edu.idat.proyectofinal.viewmodel.ExamenesViewModel

class ExamenesFragment : Fragment() {

    private var _binding: FragmentExamenesBinding? = null

    private val binding get() = _binding!!
    private lateinit var examenesViewModel: ExamenesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExamenesBinding.inflate(inflater, container, false)
        binding.rvexamenes.layoutManager = LinearLayoutManager(requireActivity())
        examenesViewModel = ViewModelProvider(requireActivity()).get(ExamenesViewModel::class.java)
        listarExamen()
        return binding.root

    }

    private fun listarExamen(){
        examenesViewModel.listarExamenes().observe(viewLifecycleOwner,
            Observer{
                binding.rvexamenes.adapter = ExamenesAdapter(it)})
    }

}