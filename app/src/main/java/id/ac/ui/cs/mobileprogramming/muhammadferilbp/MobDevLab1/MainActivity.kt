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
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private var wifiManager: WifiManager? = null
    private var stringBuilder = StringBuilder()
    var textView : TextView? = null
    private var wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val results = wifiManager!!.scanResults
            unregisterReceiver(this)

            for (scanResult in results) {
                stringBuilder.append(scanResult.SSID.toString() + "\n")
                textView = findViewById(R.id.textView)
                textView!!.text = stringBuilder.toString()
            }
            getRequest(stringBuilder.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            wifiManager!!.startScan()

        }
    }

    fun getRequest(stringData: String?) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
                .url("https://postman-echo.com/get?data=$stringData")
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(request: Request?, e: IOException?) {
                runOnUiThread { //Handle UI here
                    findViewById<TextView>(R.id.textView2).text = "gagal"
                }
            }

            override fun onResponse(response: Response?) {
                val res = response!!.body().string()

                runOnUiThread { //Handle UI here
                    findViewById<TextView>(R.id.textView2).text = "Ini reponse : \n$res"
                }
            }
        })
    }
}