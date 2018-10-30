package com.znuri.zuhdannur.smsgateaway.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Adapter.OliAdapter
import com.znuri.zuhdannur.smsgateaway.Model.Oli
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.activity_list_oli.*

class ListOliActivity : AppCompatActivity() {
    lateinit var adapter:OliAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_oli)
        try{
            this.adapter = OliAdapter(this,initData())
            rcViewOli.layoutManager = LinearLayoutManager(this)
            rcViewOli.adapter = this.adapter
        }catch (e:Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
            Log.e("error",e.message)
        }
    }
    fun initData() : ArrayList<Oli>{
        var data = ArrayList<Oli>()
        data.add(Oli("TOP 1","Rp 50.000"))
        data.add(Oli("FEDERAL","Rp 60.000"))
        data.add(Oli("FORMULA ONE","Rp 40.000"))
        return data
    }
}
