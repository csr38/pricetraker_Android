package com.example.pricetraker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_destacado_detail.*

class DestacadoDetail : AppCompatActivity(), OnDestacadoClickListener {
    val titles = arrayOf("Notebook",
        "Lacteos",
        "Smartphone",
        "Otros",
        "Otros",
        "Otros")

    val details = arrayOf("Tecnologia",
        "Supermercado",
        "Tecnologia",
        "otro",
        "otro",
        "otro")


    val image_url = arrayOf("https://i.blogs.es/f32047/xiaomi-mi-notebook/450_1000.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwW3EF3Q7Uds33gKH9MIcJ1EYVFI9lQIfQAQ&usqp=CAU",
        "https://media.wired.com/photos/621980b1aaf30ea1c35e400a/191:100/w_2580,c_limit/Gear-Samsung-S22-Series.jpg","https://www.notebookcheck.org/uploads/tx_nbc2/Xiaomi12.JPG","g","g"
    )

    val precios = arrayOf("$120.000",
        "$240.000",
        "$300.000",
        "$200.000",
        "$150.000",
        "$50.000")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destacado_detail)

        val name = intent.getStringExtra("name")

        destacado_title.text = name

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapterDestacadoDetail(this, titles, details, image_url, precios)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }

    override fun onDestacadoItemClicked(position: Int, titles: Array<String>) {
        val lanzar = Intent(this@DestacadoDetail, ViewProducto::class.java)

        lanzar.putExtra( "titles", titles[position])
        lanzar.putExtra("details", details[position])
        lanzar.putExtra("image_url", image_url[position])
        lanzar.putExtra("precios", precios[position])

        startActivity(lanzar)
    }
}


