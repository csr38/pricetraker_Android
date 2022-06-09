package com.example.pricetraker.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pricetraker.data.DataProducto

import com.example.pricetraker.databinding.CardLayoutProductoBinding

class ProductoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = CardLayoutProductoBinding.bind(view)
    fun render(dataProducto: DataProducto, onClickListener:(DataProducto)->Unit){
        binding.itemTitle.text = dataProducto.titles
        binding.itemDetail.text = dataProducto.details
        binding.itemPrecio.text = dataProducto.precios.toString()

        Glide.with(binding.itemImage.context).load(dataProducto.image_url).into(binding.itemImage)
        itemView.setOnClickListener{onClickListener(dataProducto)}
    }
}