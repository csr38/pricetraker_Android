package com.example.pricetraker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pricetraker.R
import com.example.pricetraker.data.DataProducto

import com.squareup.picasso.Picasso

class ProductoAdapter(private val productoList:List<DataProducto>, private val onClickListener:(DataProducto)->Unit): RecyclerView.Adapter<ProductoViewHolder>() {


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