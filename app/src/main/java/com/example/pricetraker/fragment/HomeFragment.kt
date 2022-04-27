package com.example.pricetraker.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pricetraker.CustomAdapter
import com.example.pricetraker.DestacadoDetail
import com.example.pricetraker.OnDestacadoClickListener
import com.example.pricetraker.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(R.layout.fragment_home), OnDestacadoClickListener {
    val titles = arrayOf("Notebook",
        "Licores",
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

    val images = intArrayOf(
        R.drawable._50_1000,
        R.drawable.licores,
        R.drawable.smartphone,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = CustomAdapter(this, titles, details, images)


        return view
    }

    override fun onDestacadoItemClicked(position: Int, titles: Array<String>) {
        //Toast.makeText(this.context, "Hola "+ position, Toast.LENGTH_LONG).show()
        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)
        lanzar.putExtra("name", titles[position])
        startActivity(lanzar)
    }
}