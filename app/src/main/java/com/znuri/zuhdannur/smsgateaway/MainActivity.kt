package com.znuri.zuhdannur.smsgateaway

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.znuri.zuhdannur.smsgateaway.Activity.AddActivity
import com.znuri.zuhdannur.smsgateaway.Adapter.DataAdapter
import com.znuri.zuhdannur.smsgateaway.DB.DBHelpear
import com.znuri.zuhdannur.smsgateaway.Fragment.*
import com.znuri.zuhdannur.smsgateaway.Model.PelangganData

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public lateinit var adapter: DataAdapter
    lateinit var helper:DBHelpear
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = InfoFragment.newInstance()
        addFragment(fragment)

    }

    fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content,fragment,fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {
            when(p0.itemId){
                R.id.info->{
                    val fragment = InfoFragment.newInstance()
                    addFragment(fragment)
                    return true
                }
                R.id.home->{
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                    return true
                }
                R.id.note->{
                    val fragment = NoteFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.akun->{
                    val fragment = ProfileFragment()
                    addFragment(fragment)
                    return true
                }
                R.id.menus->{
                    val fragment = ProdukFragment()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }

    }

    private fun getData() : ArrayList<PelangganData>{

        return helper.readAllData()
    }
}
