package com.znuri.zuhdannur.smsgateaway.Activity

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Api.ApiServices
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.MainActivity
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_send.*

class DetailActivity : AppCompatActivity() {
    lateinit var helper: DBHelpear
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        helper = DBHelpear(this)
        var id: String = ""
        if (intent.extras != null) {
            val bundle = intent.extras
            getPelanggan(bundle.getString("id"))
            id = bundle.getString("id")

        } else Toast.makeText(this, "" + intent.getStringExtra("id"), Toast.LENGTH_LONG).show()
        btnSelesai.setOnClickListener {
            helper.deletePelanggan(id)
            startActivity(Intent(this@DetailActivity, MainActivity::class.java))
        }

        kirim.setOnClickListener {
            val service = ApiServices.create()
                service.getMessage("kirim_sms", "pczuhdan33@gmail.com",
                        "Hm123123", nohape.text.toString(),"Atas Nama "+namapel.text.toString()+"\n Dengan Plat "+
                        noplat.text.toString()+"\nDaftar Perbaikan \n"+daftarperbaikan.text.toString()).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result ->
                            Toast.makeText(this, "Sukses", Toast.LENGTH_LONG).show()
                        }, {

                        })
            Snackbar.make(it,"Data Terkirim Ke Nomor "+nohape.text.toString(), Snackbar.LENGTH_LONG).show()
        }
    }

    fun getPelanggan(id:String){
        var items = helper.readPelanggan(id)
        for (data in items){
            namapel.text = data.namaPelanggan
            nohape.text = data.nomor_telepon
            noplat.text = data.plat
            daftarperbaikan.text = "Ganti Oli : "+data.oli+"\n\n"+"Keterangan Lain : \n"+data.description

        }
    }
}
