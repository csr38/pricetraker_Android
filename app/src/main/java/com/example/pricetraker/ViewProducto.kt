package com.example.pricetraker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_destacado_detail.*
import kotlinx.android.synthetic.main.activity_view_producto.*

class ViewProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_producto)
        //val name = intent.getStringExtra("name")
        val titles = intent.getStringExtra("titles")
        val details = intent.getStringExtra("details")
        val image_url = intent.getStringExtra("image_url")
        val precio = intent.getStringExtra("precios")



        Picasso.get().load(image_url).placeholder(R.drawable.ic_launcher_background).into(item_image)
        textView2.text = titles
        textView3.text = details
        textView4.text = precio
    }






}