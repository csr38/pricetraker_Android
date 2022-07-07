package com.example.pricetraker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pricetraker.recyclerview.adapter.ProductoAdapter
import com.example.pricetraker.data.DataProducto
import com.example.pricetraker.data.Producto
import com.example.pricetraker.databinding.ActivityDestacadoDetailBinding
import com.example.pricetraker.provider.productos.BebidasProvider
import com.example.pricetraker.provider.productos.LacteosProvider
import com.example.pricetraker.provider.productos.NotebookProvider
import com.google.firebase.database.*

class DestacadoDetail : AppCompatActivity() {

    private  lateinit var binding: ActivityDestacadoDetailBinding

    private lateinit var dbref : DatabaseReference
    private lateinit var productoArrayList: MutableList<Producto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestacadoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.setHasFixedSize(true)
        productoArrayList = mutableListOf<Producto>()
        //getUserData()
        initRecyclerView()

    }
/*
    private fun getUserData() {
        var hola = 1
        dbref = FirebaseDatabase.getInstance().getReference("Productos")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //productoArrayList.clear()
                if (snapshot.exists()){
                    for(productoSnapshot in snapshot.children){
                        val producto = productoSnapshot.getValue(Producto::class.java)
                        productoArrayList.add(Producto("https://media.solotodo.com/media/cache/0f/66/0f6603b538e9de6f753099c71c57b954.png","producto.marca","producto.precio","producto.sku"))
                        //Toast.makeText(this@DestacadoDetail,productoArrayList[0].imagen.toString(),2).show()
                        hola = hola+1
                    }

                    binding.recyclerView.adapter= ProductoAdapter(productoArrayList){ listaproducto ->
                        onItemSelected(
                            listaproducto
                        )

                    }


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DestacadoDetail, error.message, Toast.LENGTH_SHORT).show()
            }
        })


    }
*/

    private fun initRecyclerView(){

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        val opcion = intent.getIntExtra("opcion", 1)
        if(opcion == 1){
            var hola = 1
            dbref = FirebaseDatabase.getInstance().getReference("Productos")
            dbref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    productoArrayList.clear()
                    if (snapshot.exists()){

                        for(productoSnapshot in snapshot.children){
                            val producto = productoSnapshot.getValue(Producto::class.java)

                            productoArrayList.add(producto!!)

                            //Toast.makeText(this@DestacadoDetail,productoArrayList[0].imagen.toString(),2).show()
                            hola = hola+1
                        }


                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@DestacadoDetail, error.message, Toast.LENGTH_SHORT).show()
                }
            })


            binding.recyclerView.adapter=
                ProductoAdapter(productoArrayList){ listaproducto ->
                    onItemSelected(
                        listaproducto
                    )

                }

        }/*
        else if(opcion == 2){
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
        }*/

    }

    fun onItemSelected(producto: Producto){

        val lanzar = Intent(this@DestacadoDetail, ViewProducto::class.java)
        lanzar.putExtra("titles", producto.marca)
        lanzar.putExtra("details",producto.sku)
        lanzar.putExtra("image_url", producto.imagen)
        lanzar.putExtra("precios", producto.precio)

        startActivity(lanzar)
    }




}


