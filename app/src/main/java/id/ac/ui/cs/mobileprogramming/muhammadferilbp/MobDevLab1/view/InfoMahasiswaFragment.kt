package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.R
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.model.Mahasiswa
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.viewmodels.MahasiswaViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InfoMahasiswaFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var mahasiswaViewModel: MahasiswaViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_mahasiswa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mahasiswaViewModel = ViewModelProviders.of(requireActivity()).get(MahasiswaViewModel::class.java)
        mahasiswaViewModel!!.mahasiswaData.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.nama).setText(it.nama)
            view.findViewById<TextView>(R.id.npm).setText(it.npm)
            view.findViewById<TextView>(R.id.tahun).setText(it.tahunAngkata)
        })
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoMahasiswaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}