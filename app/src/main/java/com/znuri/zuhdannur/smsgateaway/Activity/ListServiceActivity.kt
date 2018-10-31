package com.znuri.zuhdannur.smsgateaway.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.znuri.zuhdannur.smsgateaway.Adapter.ServicesAdapter
import com.znuri.zuhdannur.smsgateaway.Model.Service
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.activity_list_service.*

class ListServiceActivity : AppCompatActivity() {
    lateinit var adapter:ServicesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_service)
        try{
            this.adapter = ServicesAdapter(this,initData())
            rcViewService.layoutManager = LinearLayoutManager(this)
            rcViewService.adapter = adapter
        }catch (e:Exception){

        }
    }
    fun initData(): ArrayList<Service>{
        var data = ArrayList<Service>()
        data.add(Service("Service Bulanan ","Rp 50.000","Pemerikasaan Sperpart,Cuci Kendaraan"))
        data.add(Service("Service","Rp 51.000",""))
        return data
    }
}
