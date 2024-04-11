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
import pe.edu.idat.proyectofinal.databinding.FragmentEventosBinding
import pe.edu.idat.proyectofinal.view.adapter.EventosAdapter
import pe.edu.idat.proyectofinal.viewmodel.EventosViewModel

class EventosFragment : Fragment() {
    private  var _binding: FragmentEventosBinding? = null
    private  val binding get() = _binding!!
    private lateinit var eventosViewModel: EventosViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventosBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvevento.layoutManager = LinearLayoutManager(requireContext())
        eventosViewModel = ViewModelProvider(this).get(EventosViewModel::class.java)
        val idUsuario = 4
        listarEventos(idUsuario)
    }
    private fun listarEventos(idUsuario: Int) {
        eventosViewModel.listarEventos(idUsuario).observe(viewLifecycleOwner, Observer { eventos ->
            eventos?.let {
                binding.rvevento.adapter = EventosAdapter(it)
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}