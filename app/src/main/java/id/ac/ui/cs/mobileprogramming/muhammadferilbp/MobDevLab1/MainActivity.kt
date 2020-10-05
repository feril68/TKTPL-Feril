package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var seconds: Long = 0
    private var running: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Warning")
        alertBuilder.setMessage("Ingin Keluar Gan?")

        alertBuilder.setNegativeButton("Tidak") { dialog, which ->
            dialog.cancel()
        }

        alertBuilder.setPositiveButton("YAYA") { dialog, which ->
            super.onBackPressed()
        }
        val showAlert = alertBuilder.create()
        showAlert.show()
    }

    fun onClickStart(view: View){
        var secondInputObj: EditText = findViewById(R.id.secondInput)
        var secondShowObj: TextView = findViewById(R.id.secondShow)
        var secondInputVal = secondInputObj.text.toString()

        seconds = secondInputVal.toLong()
        running = true
        secondShowObj.setVisibility(View.VISIBLE)
        secondShowObj.setText(secondInputVal)
        secondInputObj.setVisibility(View.GONE)

        startCountDown()
    }

    fun onClickReset(view: View){
        var secondInputObj: EditText = findViewById(R.id.secondInput)
        var secondShowObj: TextView = findViewById(R.id.secondShow)
        running = false
        seconds = 0
        secondShowObj.setVisibility(View.GONE)
        secondShowObj.setText(null)
        secondInputObj.setVisibility(View.VISIBLE)
        secondInputObj.setText(null)

    }

    private fun startCountDown() {
        var secondShowObj: TextView = findViewById(R.id.secondShow)
        var secondInputObj: EditText = findViewById(R.id.secondInput)
        var handler: Handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                if (running && seconds > 0) {
                    secondShowObj.setText(seconds.toString())
                    seconds--
                    handler.postDelayed(this, 1000)
                }
                else {
                    secondShowObj.setText("Finish")
                    running = false
                    seconds = 0
                }
            }
        })
    }

}