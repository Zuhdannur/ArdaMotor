package com.znuri.zuhdannur.smsgateaway.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znuri.zuhdannur.smsgateaway.LoginActivity

import com.znuri.zuhdannur.smsgateaway.R
import com.znuri.zuhdannur.smsgateaway.Session.SaveSharedPrefrences
import kotlinx.android.synthetic.main.fragment_profile.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProfileFragment : Fragment() {
    val save:SaveSharedPrefrences = SaveSharedPrefrences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        view.btnLogout.setOnClickListener {
            save.setLoggedIn(context,false)
            startActivity(Intent(context,LoginActivity::class.java))
        }
        return view
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ProfileFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
