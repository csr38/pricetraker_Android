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
import com.example.pricetraker.provider.categorias.CategoriasDestacadasProvider
import com.example.pricetraker.databinding.FragmentHomeBinding
import com.example.pricetraker.provider.productos.BebidasProvider
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment(): Fragment(R.layout.fragment_home){

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        view.recyclerView.layoutManager = LinearLayoutManager(activity)

        view.recyclerView.adapter = CategoriasAdapter(CategoriasDestacadasProvider.listaDataCategoriasDestacadas) { categoriasdestacadas ->
            onItemSelected(
                categoriasdestacadas
            )
        }

        return view
    }

    fun onItemSelected(dataCategorias: DataCategorias){
        //Toast.makeText(this.context, categoriasDestacadas.titles, Toast.LENGTH_SHORT).show()

        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)
        lanzar.putExtra("opcion", dataCategorias.id)
        startActivity(lanzar)
    }

}