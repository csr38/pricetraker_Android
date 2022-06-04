package com.example.pricetraker.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.pricetraker.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.launch

class HomeFragment: Fragment(R.layout.fragment_home), OnDestacadoClickListener {



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
        "https://media.wired.com/photos/621980b1aaf30ea1c35e400a/191:100/w_2580,c_limit/Gear-Samsung-S22-Series.jpg","g","g","g"
    )

    val producto = arrayOf(titles,details, image_url)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        view.recyclerView.layoutManager = LinearLayoutManager(activity)

        view.recyclerView.adapter = CustomAdapter(this, titles, details, image_url,producto)


        return view
    }

    override fun onDestacadoItemClicked(position: Int, titles: Array<String>) {

        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)

        lanzar.putExtra("name", titles[position])
        startActivity(lanzar)
    }

}