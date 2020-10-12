package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.view.ListMahasiswaFragment

class MainActivity : AppCompatActivity() {

    private val listMahasiswaFragment : ListMahasiswaFragment = ListMahasiswaFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, listMahasiswaFragment)
            .commit()
    }
}