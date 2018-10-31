package com.znuri.zuhdannur.smsgateaway.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znuri.zuhdannur.smsgateaway.Model.Service

import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.list_service.view.*

class ServicesAdapter(private val context: Context,data:ArrayList<Service>) : RecyclerView.Adapter<ServicesAdapter.ViewHolders>() {
    var datas:ArrayList<Service>
    init {
        datas = data
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
    = ServicesAdapter.ViewHolders(LayoutInflater.from(context).inflate(R.layout.list_service,p0,false))

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(p0: ViewHolders, p1: Int) {
        p0.bind(datas[p1])
    }

    class ViewHolders(view:View) : RecyclerView.ViewHolder(view) {
        fun bind(items:Service){
            itemView.namaService.text = items.nameServiec
            itemView.hargaService.text = items.hargaService
            itemView.deskripsiService.text = items.deskripsiService
        }
    }
}