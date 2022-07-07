package com.example.pricetraker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pricetraker.R
import com.example.pricetraker.databinding.ActivityViewProductoBinding


class ViewProducto : AppCompatActivity() {
    private lateinit var  binding: ActivityViewProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val name = intent.getStringExtra("name")
        val titles = intent.getStringExtra("titles")
        val details = intent.getStringExtra("details")
        val image_url = intent.getStringExtra("image_url")
        val precio = intent.getStringExtra("precios")

        this.setTitle(titles)

        Glide.with(binding.itemImage.context).load(image_url).into(binding.itemImage)
        binding.textView2.text = titles
        binding.textView4.text = ("sku"+details)
        binding.textView3.text = ("$"+precio)
    }





}