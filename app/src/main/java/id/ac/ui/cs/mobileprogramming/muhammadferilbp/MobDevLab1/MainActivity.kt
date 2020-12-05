package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            getRequest()

        }
    }

    fun getRequest() {
        val client = OkHttpClient()
        val stringIdAreaGroup = "1642911,1648473,1645518,1625084,1649378"

        val request: Request = Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/group?id=$stringIdAreaGroup&appid=63fcf1ce1c302ff0f1447db2fc1f943e")
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(request: Request?, e: IOException?) {
                runOnUiThread { //Handle UI here
                    findViewById<TextView>(R.id.textView).text = "gagal"
                }
            }

            override fun onResponse(response: Response?) {
                val res = response!!.body().charStream()
                val gsonObject = Gson().fromJson(res, OpenWeatherEntity.ApiCuacaBody::class.java)

                val strTemperature = gsonObject.list[0].main.temp.toString()
                val strName = gsonObject.list[0].name
                runOnUiThread { //Handle UI here
                    findViewById<TextView>(R.id.textView).text =
                            "${strName} : \n${strTemperature} Kelvin"
                }
            }
        })
    }
}

/*
*
* ini pake JSONobject
*
 */
//                val jsonObject = JSONObject(res)
//                val listCuaca : JSONArray = jsonObject.get("list") as JSONArray
//                val cuacaOneItem : JSONObject = listCuaca.get(0) as JSONObject
//                val cuacaOneItemMain : JSONObject = cuacaOneItem.getJSONObject("main")
//                val strTemperature = cuacaOneItemMain.getString("temp")
//                val strName = cuacaOneItem.getString("name")
//                val strTemperature =
//                        jsonObject.getJSONArray("list")
//                                .getJSONObject(0)
//                                .getJSONObject("main")
//                                .getString("temp")
//                val strName =
//                        jsonObject.getJSONArray("list")
//                                .getJSONObject(0)
//                                .getString("name")
/*
*
* ini pake GSON
*
 */