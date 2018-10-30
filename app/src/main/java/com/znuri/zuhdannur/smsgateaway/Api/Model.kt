package com.znuri.zuhdannur.smsgateaway.Api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model {
    @SerializedName("data")
    @Expose
    open val data: String? = null
}