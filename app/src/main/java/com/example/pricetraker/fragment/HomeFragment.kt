package com.example.pricetraker.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import com.example.pricetraker.*
import com.example.pricetraker.activity.DestacadoDetail
import com.example.pricetraker.adapter.CategoriasAdapter
import com.example.pricetraker.adapter.ProductoAdapterHorizontal
import com.example.pricetraker.adapter.SliderAdapter
import com.example.pricetraker.data.DataCategorias
import com.example.pricetraker.data.DataProductoHorizontal
import com.example.pricetraker.provider.categorias.CategoriasDestacadasProvider
import com.example.pricetraker.databinding.FragmentHomeBinding
import com.example.pricetraker.provider.ProductoHorizontalProvider
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment(): Fragment(R.layout.fragment_home){

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var vpSlider : ViewPager
    lateinit var rvBaju : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        activity?.setTitle("Home")

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        view.recyclerView.layoutManager = LinearLayoutManager(activity)

        view.recyclerView.adapter = CategoriasAdapter(CategoriasDestacadasProvider.listaDataCategoriasDestacadas) { categoriasdestacadas ->
            onItemSelected(
                categoriasdestacadas
            )
        }

        vpSlider = view.findViewById(R.id.vp_slider)

        val arraySlider = ArrayList<Int>()

        arraySlider.add(R.drawable.samsung_galaxy_s6_29793_g_alt)
        arraySlider.add(R.drawable.samsung_galaxy_s6_29793_g_alt)
        arraySlider.add(R.drawable.samsung_galaxy_s6_29793_g_alt)

        val sliderAdapter = SliderAdapter(arraySlider, activity)
        vpSlider.adapter = sliderAdapter

        //RecyclerView

        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        rvBaju = view.findViewById(R.id.rv_baju)

        val adapterBaju = ProductoAdapterHorizontal(ProductoHorizontalProvider.listaDataProductoHorizontal){productoshorizontaldestacados->
            onItemSelectedDos(
                productoshorizontaldestacados
            )

        }
        rvBaju.setHasFixedSize(true)
        rvBaju.layoutManager = lm
        rvBaju.adapter = adapterBaju

        return view
    }

    fun onItemSelected(dataCategorias: DataCategorias){
        //Toast.makeText(this.context, categoriasDestacadas.titles, Toast.LENGTH_SHORT).show()

        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)
        lanzar.putExtra("opcion", dataCategorias.id)
        startActivity(lanzar)
    }
    fun onItemSelectedDos(dataProductoHorizontal: DataProductoHorizontal){
        //Toast.makeText(this.context, categoriasDestacadas.titles, Toast.LENGTH_SHORT).show()

        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)
        lanzar.putExtra("opcion", dataProductoHorizontal.precioProducto)
        startActivity(lanzar)
    }



}


