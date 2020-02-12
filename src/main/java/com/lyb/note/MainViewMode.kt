package com.lyb.note

import android.app.Application
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bigkoo.pickerview.builder.TimePickerBuilder
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class MainViewMode() : ViewModel(){

    var data_year = MutableLiveData<String>()
    var data_month = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
    }


    var list = MutableLiveData<List<ThingsBean>>()


}