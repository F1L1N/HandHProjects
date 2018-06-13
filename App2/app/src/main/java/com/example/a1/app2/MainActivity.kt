package com.example.a1.app2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener { startActivity(Intent(this, Activity1::class.java)) }
        button2.setOnClickListener { startActivity(Intent(this, Activity2::class.java)) }
    }
}
