package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1.model.Mahasiswa


class MahasiswaViewModel: ViewModel() {
    val mahasiswaData = MutableLiveData<Mahasiswa>()

    fun setMahasiswaData(mahasiswa: Mahasiswa){
        mahasiswaData.value = mahasiswa
    }

}