package com.znuri.zuhdannur.smsgateaway.Session

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.znuri.zuhdannur.smsgateaway.Session.PrefrencesUtility.*



class SaveSharedPrefrences {
    var perf:PrefrencesUtility = PrefrencesUtility()
    fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }


    fun setLoggedIn(context: Context?, loggedIn: Boolean) {
        val editor = getPreferences(context!!).edit()
        editor.putBoolean(perf.LOGGED_IN_PREF, loggedIn)
        editor.apply()
    }

    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    fun getLoggedStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(perf.LOGGED_IN_PREF, false)
    }
}