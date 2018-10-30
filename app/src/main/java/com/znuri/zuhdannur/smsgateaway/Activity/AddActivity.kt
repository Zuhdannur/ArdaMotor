package com.znuri.zuhdannur.smsgateaway.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.MainActivity
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    lateinit var helper: DBHelpear
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val actionBar:ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        helper = DBHelpear(this)
        gantiOli.setOnClickListener {
            if(gantiOli.isChecked)oli.visibility = View.VISIBLE
            else oli.visibility = View.GONE
        }
        service.setOnClickListener {
            if(service.isChecked)kebutuhanservices.visibility = View.VISIBLE
            else kebutuhanservices.visibility = View.GONE
        }
        btnClick.setOnClickListener {
            if(addPelanggan()){
                Snackbar.make(it,"Data Berhasil Dimasukan",Snackbar.LENGTH_LONG).show()
                startActivity(Intent(this@AddActivity,MainActivity::class.java))
            }else{
                Snackbar.make(it,"Isi Data Terlebih Dahulu",Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun insertValidate()  : Boolean{
        var boolean:Boolean = false;
        if(nama.text.isEmpty() || notlp.text.isEmpty() || gantiOli.isChecked == false && service.isChecked == false || platnomor.text.isEmpty() ){
             boolean = false
        }
        else boolean = true
        return boolean
    }

    fun addPelanggan() :Boolean{
        if(insertValidate()){
            var userName = nama.text.toString()
            var id = ""+helper.getPelangganLastID()
            var deskripsi = deskripsi.text.toString()
            var plat = platnomor.text.toString()
            var nohp = notlp.text.toString()
            var olis:String = ""
            if(gantiOli.isChecked){
                olis = merkOli.text.toString()
            }
            helper.insertPelanggan(PelangganData(id=id,namaPelanggan = userName,description = deskripsi,plat = plat,oli = olis,nomor_telepon = nohp))
            Toast.makeText(this,"Berhasil Dimasukan",Toast.LENGTH_LONG).show()
            this.nama.setText("")
            this.deskripsi.setText("")
            this.platnomor.setText("")
            this.notlp.setText("")
            this.gantiOli.isChecked = false
            this.service.isChecked = false
            return true
        }
        else{
           return false
        }

    }


}
