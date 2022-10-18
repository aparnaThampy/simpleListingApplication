package com.example.samplelistingapp.util

import android.content.Context
import android.content.res.AssetManager
import android.widget.Toast
import com.example.samplelistingapp.data.Lists
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

object util {
     fun loadJSONFromAsset(context: Context?): Lists? {
        try {
            val assetManager: AssetManager? = context?.assets
            val ims: InputStream? = assetManager?.open("CONTENTLISTINGPAGE-PAGE1.json")
            val gson = Gson()
            val reader: Reader = InputStreamReader(ims)
            return gson.fromJson(reader, Lists::class.java)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
     fun showToast(item: Int, context: Context?) {
        Toast.makeText(context, item, Toast.LENGTH_LONG).show()
    }
     fun showToast(item: String, context: Context?) {
        Toast.makeText(context, item, Toast.LENGTH_LONG).show()
    }
}