package com.znuri.zuhdannur.smsgateaway

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val tabHost = findViewById<TabHost>(R.id.tabhost)

    }

    fun addTab(tabHost: TabHost,className: Class<*>){

    }
}
