package com.example.pricetraker.recyclerview.viewholder

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pricetraker.data.DataProducto
import com.example.pricetraker.data.Producto

import com.example.pricetraker.databinding.CardLayoutProductoBinding
import kotlin.coroutines.coroutineContext

class ProductoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = CardLayoutProductoBinding.bind(view)
    fun render(producto: Producto, onClickListener:(Producto)->Unit){
        binding.itemTitle.text = producto.marca
        binding.itemDetail.text = "sku: "+producto.sku
        binding.itemPrecio.text = "$"+producto.precio
        Glide.with(binding.itemImage.context).load(producto.imagen).into(binding.itemImage)
        itemView.setOnClickListener{onClickListener(producto)}
    }
}