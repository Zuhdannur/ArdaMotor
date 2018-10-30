package com.znuri.zuhdannur.smsgateaway.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.Model.Sperpart
import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add_sperpart.*

class AddSperpartActivity : AppCompatActivity() {
    lateinit var helper:DBHelpear
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sperpart)
        helper = DBHelpear(this)
        tambah.setOnClickListener {
            if(validasi()){
                addSperpart()
            }else{
                Snackbar.make(it,"Isi Kolom Terlebih dahulu",Snackbar.LENGTH_LONG).show()
            }
        }
    }

    fun validasi():Boolean{
        var valid:Boolean
        if(nameSperpart.text.isEmpty() || price.text.isEmpty()){
            valid = false
        }
        else valid =  true

        return valid
    }

    fun addSperpart(){
            var namaSperpart = nameSperpart.text.toString()
            var id = "1"
            var price = price.text.toString()
            helper.insertSperpart(Sperpart(id = id,namaSperpart = namaSperpart,harga = price.toIntOrNull()))
            Toast.makeText(this,"Berhasil Dimasukan", Toast.LENGTH_LONG).show()
            this.nameSperpart.setText("")
            this.price.setText("")
    }
}
