package com.example.pricetraker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pricetraker.adapter.ProductoAdapter
import com.example.pricetraker.data.DataProducto
import com.example.pricetraker.databinding.ActivityDestacadoDetailBinding
import com.example.pricetraker.provider.productos.BebidasProvider
import com.example.pricetraker.provider.productos.LacteosProvider
import com.example.pricetraker.provider.productos.NotebookProvider
import kotlinx.android.synthetic.main.card_layout_producto.*

class DestacadoDetail : AppCompatActivity() {

    private  lateinit var binding: ActivityDestacadoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestacadoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    private fun initRecyclerView(){

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        NotebookProvider.listaDataProducto.add(
            DataProducto("HP",
                "Invento",
                "l",
                120))

        val opcion = intent.getIntExtra("opcion", 1)
        if(opcion == 1){
            binding.recyclerView.adapter=
                ProductoAdapter(NotebookProvider.listaDataProducto){ listaproducto ->
                    onItemSelected(
                        listaproducto
                    )

                }
        }else if(opcion == 2){
            binding.recyclerView.adapter=
                ProductoAdapter(LacteosProvider.listaDataProducto.sortedBy { it.precios }){ listaproducto ->
                    onItemSelected(
                        listaproducto
                    )

                }
        }else if(opcion == 3){
            binding.recyclerView.adapter=
                ProductoAdapter(BebidasProvider.listaDataProducto){ listaproducto ->
                    onItemSelected(
                        listaproducto
                    )

                }
        }

    }

    fun onItemSelected(dataProducto: DataProducto){

        //Toast.makeText(this, dataProducto.titles, Toast.LENGTH_SHORT).show()

        val lanzar = Intent(this@DestacadoDetail, ViewProducto::class.java)
        lanzar.putExtra("titles", dataProducto.titles)
        lanzar.putExtra("details",dataProducto.details)
        lanzar.putExtra("image_url", dataProducto.image_url)
        lanzar.putExtra("precio", dataProducto.precios)

        startActivity(lanzar)
    }




}


