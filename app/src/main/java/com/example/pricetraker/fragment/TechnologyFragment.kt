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
import com.example.pricetraker.recyclerview.adapter.CategoriasAdapter
import com.example.pricetraker.data.DataCategorias
import com.example.pricetraker.provider.categorias.CategoriasTecnologiaProvider
import com.example.pricetraker.databinding.FragmentTechnologyBinding

import kotlinx.android.synthetic.main.fragment_home.view.*


class TechnologyFragment : Fragment(R.layout.fragment_technology){

    private var _binding: FragmentTechnologyBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentTechnologyBinding.inflate(inflater, container, false)


        val view = binding.root

        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = CategoriasAdapter(CategoriasTecnologiaProvider.listaDataCategoriasDestacadas) { categoriastecnologia ->
            onItemSelected(
                categoriastecnologia
            )
        }


        return view
    }

    fun onItemSelected(dataCategorias: DataCategorias){
        //Toast.makeText(this.context, categoriasDestacadas.titles, Toast.LENGTH_SHORT).show()
        val lanzar = Intent(this@TechnologyFragment.context, DestacadoDetail::class.java)
        startActivity(lanzar)
    }

}