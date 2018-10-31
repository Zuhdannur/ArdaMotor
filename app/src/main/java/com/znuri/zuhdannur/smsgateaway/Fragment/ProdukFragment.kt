package com.znuri.zuhdannur.smsgateaway.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znuri.zuhdannur.smsgateaway.Activity.ListOliActivity
import com.znuri.zuhdannur.smsgateaway.Activity.ListServiceActivity

import com.znuri.zuhdannur.smsgateaway.R
import kotlinx.android.synthetic.main.fragment_produk.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ProdukFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ProdukFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ProdukFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_produk, container, false)
        view.serviceBerkala.setOnClickListener {
            //startActivity(Intent(context,))
        }
        view.produkOli.setOnClickListener {
            startActivity(Intent(context,ListOliActivity::class.java))
        }
        view.serviceBerkala.setOnClickListener {
            startActivity(Intent(context,ListServiceActivity::class.java))
        }
        return view
    }





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ProdukFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
