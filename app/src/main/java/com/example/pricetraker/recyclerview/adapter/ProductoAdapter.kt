package com.example.pricetraker.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pricetraker.R
import com.example.pricetraker.data.DataProducto
import com.example.pricetraker.data.Producto
import com.example.pricetraker.recyclerview.viewholder.ProductoViewHolder
import com.google.firebase.database.core.view.View

class ProductoAdapter(private val productoList:List<Producto>, private val onClickListener:(Producto)->Unit): RecyclerView.Adapter<ProductoViewHolder>() {


    override  fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProductoViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return ProductoViewHolder(layoutInflater.inflate(R.layout.card_layout_producto, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ProductoViewHolder, i: Int){
        val item = productoList[i]
        viewHolder.render(item, onClickListener)

    }
    override fun getItemCount(): Int = productoList.size

}