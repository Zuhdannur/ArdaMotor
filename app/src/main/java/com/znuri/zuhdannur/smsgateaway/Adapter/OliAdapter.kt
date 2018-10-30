package com.znuri.zuhdannur.smsgateaway.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znuri.zuhdannur.smsgateaway.Model.Oli
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.list_item_sperpart.view.*
import kotlinx.android.synthetic.main.list_oli.view.*

class OliAdapter(private val context: Context,data:ArrayList<Oli>) : RecyclerView.Adapter<OliAdapter.ViewHolder>() {
    var datas:ArrayList<Oli>
    init{
        datas = data
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            OliAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_oli,p0,false))

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(datas[p1])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data1:Oli){
            itemView.oliName.text = data1.namaOli
            itemView.hargaOli.text = data1.harga
        }
    }
}