package com.znuri.zuhdannur.smsgateaway.DB

import android.provider.BaseColumns

object DBContract {
    class PelangganEntry : BaseColumns{
        companion object {
            val TABLE_NAME = "pelanggan"
            val COLUMN_PELANGGAN_ID = "id_pelanggan"
            val COLUMN_NAME = "nama"
            val COLUMN_DESKRIPSI = "description"
            val COLUMN_PLAT = "plat"
            val COLUMN_NOPE = "notelp"
            val COLUMN_OLI = "oli"
        }
    }
    class Sperpart:BaseColumns{
        companion object {
            val TABLE_NAME ="sperpart"
            val COLUMN_SPERPART_ID = "id_sperpart"
            val COLUMN_NAME = "sperpart_name"
            val COLUMN_PRICE = "harga"
        }
    }
}