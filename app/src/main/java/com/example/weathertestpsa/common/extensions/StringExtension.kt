package com.example.weathertestpsa.common.extensions

import android.content.Context
import android.util.Base64
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

fun readFileAsString(base64String: String): String {
    val data = Base64.decode(base64String, Base64.DEFAULT)
    return String(data, Charset.forName("UTF-8"))
}

fun Context.loadJSONFromAsset(): String? {
    val json: String?
    json = try {
        val inputStream: InputStream = this.assets.open("fr_lat_lng_city.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}
