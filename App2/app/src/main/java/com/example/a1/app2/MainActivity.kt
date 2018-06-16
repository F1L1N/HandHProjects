package com.example.a1.app2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        fun createStartIntentAct1(context: Context): Intent {
            return Intent(context, Activity1::class.java)
        }

        fun createStartIntentAct2(context: Context): Intent {
            return Intent(context, Activity2::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener { startActivity(createStartIntentAct1(this)) }
        button2.setOnClickListener { startActivity(createStartIntentAct2(this)) }
    }
}
