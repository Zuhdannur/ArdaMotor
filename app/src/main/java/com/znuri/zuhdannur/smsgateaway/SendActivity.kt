package com.znuri.zuhdannur.smsgateaway

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Api.ApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_send.*

class SendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        val service = ApiServices.create()
        send.setOnClickListener {
            service.getMessage("kirim_sms","pczuhdan33@gmail.com",
                    "Hm123123",phoneNum.text.toString(),Message.text.toString()).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        result -> Toast.makeText(this,"Sukses",Toast.LENGTH_LONG).show()
                    },{

                    })

            //services.getRow().subscribeOn(Schedulers.newThread())
              //      .observeOn(AndroidSchedulers.mainThread())
                //    .subscribe({
                  //      result -> jumlahData.text = "${result.data} Orang"
                    //},{
                      //  error-> Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                    //})
        }
    }
}
