package com.example.pricetraker.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pricetraker.data.DataProductoHorizontal
import com.example.pricetraker.databinding.ItemProductoHorizontalBinding

class ProductoHorizontalViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemProductoHorizontalBinding.bind(view)
    fun render(dataProductoHorizontal: DataProductoHorizontal, onClickListener: (DataProductoHorizontal)->Unit){
        binding.tvHarga.text=dataProductoHorizontal.precioProducto
        binding.tvNama.text=dataProductoHorizontal.nameProduct

        Glide.with(binding.imgProduk.context).load(dataProductoHorizontal.imagenProducto).into(binding.imgProduk)
        itemView.setOnClickListener{onClickListener(dataProductoHorizontal)}


    }

}

