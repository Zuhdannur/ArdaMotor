package com.znuri.zuhdannur.smsgateaway.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.znuri.zuhdannur.smsgateaway.R


class InfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_info, container, false)
        return view
    }


    companion object {
        fun newInstance() : InfoFragment{
            var fragment = InfoFragment()
            var args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
