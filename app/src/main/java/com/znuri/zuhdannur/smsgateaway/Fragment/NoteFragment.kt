package com.znuri.zuhdannur.smsgateaway.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Activity.AddSperpartActivity
import com.znuri.zuhdannur.smsgateaway.Adapter.DataAdapter
import com.znuri.zuhdannur.smsgateaway.Adapter.SperpartAdapter
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.Model.Sperpart

import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_note.view.*


class NoteFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var helper:DBHelpear
    lateinit var adapter: SperpartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_note, container, false)
        view.addSperpart.setOnClickListener {
            startActivity(Intent(context,AddSperpartActivity::class.java))
        }
        try{

            helper = DBHelpear(context)

            val pelangganData:ArrayList<Sperpart> = this.getData()
            this.adapter = SperpartAdapter(context,pelangganData)
            view.rcView1.layoutManager = LinearLayoutManager(context)
            view.rcView1.adapter = this.adapter
        }catch (e:Exception){
            //Toast.makeText(context,e.message, Toast.LENGTH_LONG).show()
            //Log.e("error",e.message)
        }
        //Toast.makeText(context,""+helper.checkTable(),Toast.LENGTH_LONG).show()
        return view
    }

    fun getData() : ArrayList<Sperpart>{
        var data = ArrayList<Sperpart>()
        data.add(Sperpart("1","Canvas Rem",15000))
        data.add(Sperpart("2","Jok",50000))
        return data
    }


    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NoteFragment().apply {

                }
    }
}
