package com.example.pricetraker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

class CustomAdapter(private  val onDestacadoClickListener: OnDestacadoClickListener, val titles: Array<String>, val details: Array<String>, val image_url : Array<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {




    override  fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder{
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int){
        Picasso.get().load(image_url[i]).placeholder(R.drawable.ic_launcher_background).into(viewHolder.itemImage)
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]

    }

    override fun getItemCount(): Int{
        return image_url.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)

            itemView.setOnClickListener{

                val position: Int = adapterPosition
                onDestacadoClickListener.onDestacadoItemClicked(position, titles)

                //val position: Int = adapterPosition

                //Toast.makeText(itemView.context, "you clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }

        }
    }
}