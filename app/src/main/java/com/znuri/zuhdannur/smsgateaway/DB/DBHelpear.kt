package com.znuri.zuhdannur.smsgateaway.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.ArrayAdapter
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData
import com.znuri.zuhdannur.smsgateaway.Model.Sperpart

class DBHelpear(context: Context?) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABSE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        db.execSQL(SQL_DELETE_ENTRIES_SPERPART)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES_SPERPART)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)

    }
    @Throws(SQLiteConstraintException::class)
    fun insertPelanggan(pelangganData: PelangganData) :Boolean{
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.PelangganEntry.COLUMN_PELANGGAN_ID,pelangganData.id)
        values.put(DBContract.PelangganEntry.COLUMN_NAME,pelangganData.namaPelanggan)
        values.put(DBContract.PelangganEntry.COLUMN_DESKRIPSI,pelangganData.description)
        values.put(DBContract.PelangganEntry.COLUMN_OLI,pelangganData.oli)
        values.put(DBContract.PelangganEntry.COLUMN_NOPE,pelangganData.nomor_telepon)
        values.put(DBContract.PelangganEntry.COLUMN_PLAT,pelangganData.plat)
        val newRow  = db.insert(DBContract.PelangganEntry.TABLE_NAME,null,values)
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun insertSperpart(sperpart: Sperpart) :Boolean{
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.Sperpart.COLUMN_SPERPART_ID,sperpart.id)
        values.put(DBContract.Sperpart.COLUMN_NAME,sperpart.namaSperpart)
        values.put(DBContract.Sperpart.COLUMN_PRICE,sperpart.harga)

        val newRow  = db.insert(DBContract.Sperpart.TABLE_NAME,null,values)
        return true
    }


    @Throws(SQLiteConstraintException::class)
    fun deletePelanggan(userID:String?) : Boolean{
        val db = writableDatabase
        val selection = DBContract.PelangganEntry.COLUMN_PELANGGAN_ID + " LIKE ?"
        val args = arrayOf(userID)
        db.delete(DBContract.PelangganEntry.TABLE_NAME,selection,args)
        return true
    }

    fun getPelangganLastID() : Int?{
        val db = writableDatabase
        var cursor:Cursor = db.rawQuery("SELECT * FROM "+DBContract.PelangganEntry.TABLE_NAME,null)
        var id:String? = null
        if(cursor.moveToLast()){
            id = cursor.getString(0)
        }
        if(id.isNullOrEmpty()){
            id = "0"
        }
        return id!!.toInt() +1
    }

    fun checkTable():Boolean{
        val db = writableDatabase
        var cursor:Cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + DBContract.PelangganEntry.TABLE_NAME + "'", null)
        if(cursor!=null){
            if(cursor.count > 0){
                cursor.close()
                return true
            }
            cursor.close()
        }
        return false
    }

    fun getSperpartLastID() : Int?{
        val db = writableDatabase
        var cursor:Cursor = db.rawQuery("SELECT * FROM "+DBContract.Sperpart.TABLE_NAME,null)
        var id:String? = null
        if(cursor.moveToLast()){
            id = cursor.getString(0)
        }
        if(id.isNullOrEmpty()){
            id = "0"
        }
        return id!!.toInt() +1
    }

    fun readPelanggan(id:String?) : ArrayList<PelangganData>{
        val pelangan = ArrayList<PelangganData>()
        val db = writableDatabase
        var cursor:Cursor? = null
        try{
            cursor = db.rawQuery("SELECT * FROM "+DBContract.PelangganEntry.TABLE_NAME+" WHERE "+
                    DBContract.PelangganEntry.COLUMN_PELANGGAN_ID+" = '"+id+"'",null)
        }catch (e:Exception){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var pelangganID:String
        var nama:String
        var deskripsi:String
        var telp:String
        var oli:String
        var plat:String
        if(cursor!!.moveToFirst()){
            while (cursor.isAfterLast == false){
                pelangganID = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_PELANGGAN_ID))
                nama = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_NAME))
                deskripsi = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_DESKRIPSI))
                telp = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_NOPE))
                oli = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_OLI))
                plat = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_PLAT))
                pelangan.add(PelangganData(pelangganID,nama,deskripsi,plat,oli,telp))
                cursor.moveToNext()
            }
        }
        return pelangan
    }

    public fun readAllData():ArrayList<PelangganData>{
        val pelangan = ArrayList<PelangganData>()
        val db = writableDatabase
        var cursor:Cursor?
        try{
            cursor = db.rawQuery("SELECT * FROM "+DBContract.PelangganEntry.TABLE_NAME,null)
        }catch (e:Exception){
                db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var pelangganID:String
        var nama:String
        var deskripsi:String
        var telp:String
        var oli:String
        var plat:String
        if(cursor.moveToFirst()){
            while (cursor.isAfterLast == false){
                pelangganID = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_PELANGGAN_ID))
                nama = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_NAME))
                deskripsi = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_DESKRIPSI))
                telp = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_NOPE))
                oli = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_OLI))
                plat = cursor.getString(cursor.getColumnIndex(DBContract.PelangganEntry.COLUMN_PLAT))
                pelangan.add(PelangganData(pelangganID,nama,deskripsi,plat,oli,telp))
                cursor.moveToNext()
            }
        }
        return pelangan
    }

        fun readAllSperpart():ArrayList<Sperpart>{
        val sperpart = ArrayList<Sperpart>()
        val db = writableDatabase
        var cursor:Cursor? = null
        try{
            cursor = db.rawQuery("SELECT * FROM "+DBContract.Sperpart.TABLE_NAME,null)
        }catch (e:Exception){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var sperpartID:String
        var namaSperpart:String
        var harga:String

        if(cursor!!.moveToFirst()){
            while (cursor.isAfterLast == false){
                sperpartID = cursor.getString(cursor.getColumnIndex(DBContract.Sperpart.COLUMN_SPERPART_ID))
                namaSperpart = cursor.getString(cursor.getColumnIndex(DBContract.Sperpart.COLUMN_NAME))
                harga = cursor.getString(cursor.getColumnIndex(DBContract.Sperpart.COLUMN_PRICE))

                sperpart.add(Sperpart(sperpartID,namaSperpart,harga.toIntOrNull()))
                cursor.moveToNext()
            }
        }
        return sperpart
    }



    companion object {
        val DATABASE_NAME = "bengkel.db"
        val DATABSE_VERSION  = 2
        private val SQL_CREATE_ENTRIES = "CREATE TABLE "+DBContract.PelangganEntry.TABLE_NAME+"( "+
                DBContract.PelangganEntry.COLUMN_PELANGGAN_ID+" TEXT PRIMARY KEY,"+
                DBContract.PelangganEntry.COLUMN_NAME+" TEXT,"+
                DBContract.PelangganEntry.COLUMN_DESKRIPSI+" TEXT,"+
                DBContract.PelangganEntry.COLUMN_NOPE+" TEXT,"+
                DBContract.PelangganEntry.COLUMN_OLI+" TEXT,"+
                DBContract.PelangganEntry.COLUMN_PLAT+" TEXT);"
        private val SQL_CREATE_ENTRIES_SPERPART = "CREATE TABLE "+DBContract.Sperpart.TABLE_NAME+"( "+
                DBContract.Sperpart.COLUMN_SPERPART_ID+" TEXT PRIMARY KEY,"+
                DBContract.Sperpart.COLUMN_NAME+" TEXT,"+
                DBContract.Sperpart.COLUMN_PRICE+" INTEGER);"
        private val SQL_DELETE_ENTRIES_SPERPART = "DROP TABLE IF EXISTS "+DBContract.Sperpart.TABLE_NAME
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+DBContract.PelangganEntry.TABLE_NAME
    }
}