package com.example.pricetraker.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pricetraker.data.DataCategorias
import com.example.pricetraker.databinding.CardLayoutBinding

class CategoriasViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val binding = CardLayoutBinding.bind(view)
    fun render(dataCategorias: DataCategorias, onClickListener:(DataCategorias)->Unit){
        binding.itemTitle.text = dataCategorias.titles
        binding.itemDetail.text = dataCategorias.details
        Glide.with(binding.itemImage.context).load(dataCategorias.image_url).into(binding.itemImage)
        itemView.setOnClickListener{onClickListener(dataCategorias)}
    }


}