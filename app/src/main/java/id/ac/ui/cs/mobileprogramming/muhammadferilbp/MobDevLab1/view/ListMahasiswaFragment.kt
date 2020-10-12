package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.R
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.model.Mahasiswa
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.viewmodels.MahasiswaViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListMahasiswaFragment : Fragment() {
    private var mahasiswaViewModel: MahasiswaViewModel?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val listMahasiswa: ArrayList<Mahasiswa> = ArrayList()
        listMahasiswa.add(Mahasiswa("Feril", "1706075054", "2017"))
        listMahasiswa.add(Mahasiswa("Bagus", "1234567890", "2200"))
        val infoMahasiswaFragment = InfoMahasiswaFragment()
        val view : View = inflater.inflate(R.layout.fragment_list_mahasiswa, container, false)
        val button: Button = view.findViewById(R.id.button)
        val button2: Button = view.findViewById(R.id.button2)
        mahasiswaViewModel = ViewModelProviders.of(requireActivity()).get(MahasiswaViewModel::class.java)
        button.setOnClickListener {
            mahasiswaViewModel!!.setMahasiswaData(listMahasiswa[0])
            requireFragmentManager().beginTransaction().replace(R.id.fragment, infoMahasiswaFragment)
                .addToBackStack(null).commit()
        }
        button2.setOnClickListener {
            mahasiswaViewModel!!.setMahasiswaData(listMahasiswa[1])
            requireFragmentManager().beginTransaction().replace(R.id.fragment, infoMahasiswaFragment)
                .addToBackStack(null).commit()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListMahasiswaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}