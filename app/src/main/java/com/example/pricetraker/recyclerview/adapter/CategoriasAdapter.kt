package com.example.pricetraker.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pricetraker.data.DataCategorias
import com.example.pricetraker.R
import com.example.pricetraker.recyclerview.viewholder.CategoriasViewHolder

class CategoriasAdapter(private val categoriaList:List<DataCategorias>, private val onClickListener:(DataCategorias)->Unit): RecyclerView.Adapter<CategoriasViewHolder>() {


    override  fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoriasViewHolder {

        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return CategoriasViewHolder(layoutInflater.inflate(R.layout.card_layout, viewGroup, false))
    }
    override fun onBindViewHolder(viewHolder: CategoriasViewHolder, i: Int){
        val item = categoriaList[i]
        viewHolder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = categoriaList.size

}