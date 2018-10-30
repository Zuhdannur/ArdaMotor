package com.znuri.zuhdannur.smsgateaway.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.support.v7.app.AppCompatActivity
import com.znuri.zuhdannur.smsgateaway.Activity.AddActivity
import com.znuri.zuhdannur.smsgateaway.Activity.DetailActivity
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.list_item.view.*

class DataAdapter(private  val context: Context?,datas: ArrayList<PelangganData>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
     var data:ArrayList<PelangganData>
    var context1:Context? = null
    init {
    this.data = datas
        this.context1 =context
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            DataViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,p0,false))

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(p0: DataViewHolder, p1: Int) {
       p0.bindItem(this.data[p1],p1)

        p0.itemView.datas.setOnClickListener {
            val intetnt = Intent(context,DetailActivity::class.java)
            intetnt.putExtra("id",data[p1].id)
            context!!.startActivity(intetnt)

        }
    }

    class DataViewHolder(view:View) : RecyclerView.ViewHolder(view) {

            fun bindItem(PelangganData: PelangganData, position:Int){
                itemView.namaPelanggan.text = PelangganData.namaPelanggan
                itemView.deskrip.text = PelangganData.nomor_telepon
                itemView.plat.text = PelangganData.plat

            }
    }
}