package com.znuri.zuhdannur.smsgateaway.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Activity.AddActivity
import com.znuri.zuhdannur.smsgateaway.Adapter.DataAdapter
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData

import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    public lateinit var adapter: DataAdapter
    lateinit var helper:DBHelpear

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        try{

            helper = DBHelpear(context)

            val pelangganData:ArrayList<PelangganData> = this.getData()
            this.adapter = DataAdapter(context,pelangganData)
            view.rcView.layoutManager = LinearLayoutManager(context)
            view.rcView.adapter = this.adapter
        }catch (e:Exception){
            //Toast.makeText(context,e.message, Toast.LENGTH_LONG).show()
            //Log.e("error",e.message)
        }
        view.addData.setOnClickListener {
            startActivity(Intent(context,AddActivity::class.java))
        }
        return view
    }

    private fun getData() : ArrayList<PelangganData>{
        return helper.readAllData()
    }

    companion object {
        fun newInstance() : HomeFragment{
            var fragment = HomeFragment()
            var args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
