package com.znuri.zuhdannur.smsgateaway.Api

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
@GET("sms_api.php")
fun getMessage(@Query("action")action:String,@Query("email")email:String,
               @Query("passkey")passkey:String,@Query("no_tujuan")notujuan:String,
               @Query("pesan")pesan:String):Observable<Model>
    companion object ApiClient {
                fun create():ApiServices{
                    val gson  = GsonBuilder().create()
                    val retrofit = Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .baseUrl("https://reguler.medansms.co.id/")
                            .build()
                    return  retrofit.create(ApiServices::class.java)
                }
    }
}