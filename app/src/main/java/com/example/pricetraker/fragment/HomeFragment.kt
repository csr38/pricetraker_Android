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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = CustomAdapter(this)


        return view
    }

    override fun onDestacadoItemClicked(position: Int, titles: Array<String>) {
        //Toast.makeText(this.context, "Hola "+ position, Toast.LENGTH_LONG).show()
        val lanzar = Intent(this@HomeFragment.context, DestacadoDetail::class.java)
        lanzar.putExtra("name", titles[position])
        startActivity(lanzar)
    }
}