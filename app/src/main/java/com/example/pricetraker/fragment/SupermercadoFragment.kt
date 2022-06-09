package com.example.pricetraker.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pricetraker.*
import com.example.pricetraker.activity.DestacadoDetail
import com.example.pricetraker.adapter.CategoriasAdapter
import com.example.pricetraker.data.DataCategorias
import com.example.pricetraker.provider.categorias.CategoriasSupermercadoProvider
import com.example.pricetraker.databinding.FragmentSupermercadoBinding
import kotlinx.android.synthetic.main.fragment_home.view.*


class SupermercadoFragment : Fragment(R.layout.fragment_supermercado) {

    private var _binding: FragmentSupermercadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentSupermercadoBinding.inflate(inflater, container, false)
        val view = binding.root


        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = CategoriasAdapter(CategoriasSupermercadoProvider.listaDataCategoriasDestacadas) { categoriassupermercado ->
            onItemSelected(
                categoriassupermercado
            )
        }


        return view
    }

    fun onItemSelected(dataCategorias: DataCategorias){
        //Toast.makeText(this.context, categoriasDestacadas.titles, Toast.LENGTH_SHORT).show()
        val lanzar = Intent(this@SupermercadoFragment.context, DestacadoDetail::class.java)
        startActivity(lanzar)
    }

}

