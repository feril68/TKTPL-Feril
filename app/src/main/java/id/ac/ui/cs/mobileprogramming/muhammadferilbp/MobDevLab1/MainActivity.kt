package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.textView)
        val button : Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.editText)

        button.setOnClickListener(){
            val editTextString : String = editText.text.toString()
            when {
                editTextString.trim()=="" -> {
                    Toast.makeText(this,"Input Kosong Gan",Toast.LENGTH_LONG).show()
                }
                editTextString.length > 20 -> {
                    Toast.makeText(this,"Input Maks 20 aja gan",Toast.LENGTH_LONG).show()
                }
                else -> {
                    textView.text = helloName(editTextString)
                }
            }
        }
    }

    external fun helloName(string: String): String?

    companion object {
        init {
            System.loadLibrary("hello-jni")
        }
    }
}