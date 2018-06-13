package com.example.a1.app2

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_1)
        checkLang()
        checkVersion()
        checkWidth(this)
        checkOrientation()
    }

    private fun checkOrientation(): Unit =
            if (getScreenOrientation() == 'p') {
                this.imageView.setImageResource(R.drawable.ic_cross_black)
            } else {
                this.imageView.setImageResource(R.drawable.ic_pushkin_signature)
            }

    private fun checkWidth(context: Context) {
        if (getWidth(context) <= 325) {
            this.textView.setTextColor(Color.parseColor("#FF0000"))
        }
    }

    private fun getHeight(context: Context): Float {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.heightPixels / displayMetrics.density
    }

    private fun getWidth(context: Context): Float {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels / displayMetrics.density
    }

    @SuppressLint("SetTextI18n")
    private fun checkLang() {
        if (getCurrentLocaleStr(this) == "ru") {
            this.textView.text = resources.getString(R.string.poetry)
        } else {
            this.textView.text = resources.getString(R.string.no_poetry)
        }
    }

    private fun checkVersion(): Unit =
            if (Build.VERSION.SDK_INT >= 21) {
                this.button.text = "Радость и счастье"
            } else {
                this.button.text = "Боль и страдание"
            }


    private fun getScreenOrientation(): Char =
            when {
                resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT -> 'p'
                resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE -> 'a'
                else -> ' '
            }


    private fun getCurrentLocaleStr(context: Context): String =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales.get(0).toString()
            } else {
                context.resources.configuration.locale.language
            }

}
