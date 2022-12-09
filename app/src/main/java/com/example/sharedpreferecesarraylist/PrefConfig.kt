package com.example.sharedpreferecesarraylist

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PrefConfig {
    private const val LIST_KEY = "list_key100"
    fun writeListInPref(context: Context?, list: List<TaskModel?>?) {
        val gson = Gson()
        val jsonString = gson.toJson(list)
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putString(LIST_KEY, jsonString)
        editor.apply()
    }

    fun readListFromPref(context: Context?): List<TaskModel> {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val jsonString = pref.getString(LIST_KEY, "")
        val gson = Gson()
        val type =
            object : TypeToken<ArrayList<TaskModel?>?>() {}.type

        return gson.fromJson(jsonString, type)
    }
}
