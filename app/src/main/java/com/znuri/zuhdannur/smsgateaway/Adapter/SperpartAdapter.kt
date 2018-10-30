package com.znuri.zuhdannur.smsgateaway.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znuri.zuhdannur.smsgateaway.DB.DBContract
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.Model.Sperpart
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.list_item_sperpart.view.*

class SperpartAdapter(private val context: Context?,data:ArrayList<Sperpart>) : RecyclerView.Adapter<SperpartAdapter.ViewHolder>() {
    var data:ArrayList<Sperpart>
    var context1:Context? = null
    init{
        this.data = data
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)=
            SperpartAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_sperpart, p0, false))

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(this.data[p1])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(sperpart: Sperpart){
            itemView.nameSperpartView.text = sperpart.namaSperpart
            itemView.price.text = sperpart.harga.toString()
        }
    }
}