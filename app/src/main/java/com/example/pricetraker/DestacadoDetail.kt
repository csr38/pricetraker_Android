package com.example.pricetraker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_destacado_detail.*

class DestacadoDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destacado_detail)

        val name = intent.getStringExtra("name")
        tv_name.text = name
    }
}