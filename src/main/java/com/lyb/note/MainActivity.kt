package com.lyb.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.lyb.note.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding
    private lateinit var mAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        ViewModeManager.getInstance(this).changeMonthData(this,
            Observer { t -> view.tpv.text = t })
        ViewModeManager.getInstance(this).changeYearData(this,
            Observer { t -> view.tvYear.text = t })

        view.rv.layoutManager = LinearLayoutManager(this)

        var list = mutableListOf<ThingsBean>()
        for (i in 0..10) {
            var thingsBean = ThingsBean(i, 0, "", "", i)
            list.add(thingsBean)
        }
        ViewModeManager.getInstance(this).setList(list)
        ViewModeManager.getInstance(this).changList(this,
            Observer { t ->

                mAdapter = RvAdapter(t as MutableList<ThingsBean>)
                view.rv.adapter = mAdapter
            })


    }


    fun choiceTime(view: View) {
        customeTime()
    }

    //自定义时间样式
    private fun customeTime() {
        var selectedDate = Calendar.getInstance()
        var startDate = Calendar.getInstance()
        var endDate = Calendar.getInstance()

        startDate.set(2019, 1, 1)
        endDate.set(2050, 1, 1)
        TimePickerBuilder(this) { date, vi ->

            ViewModeManager.getInstance(this).setMonthData(getMonthTime(date))
            ViewModeManager.getInstance(this).setYearData(getYearTime(date))
        }.setDate(selectedDate)
            .setRangDate(startDate, endDate)

            .setContentTextSize(18)
            .setType(booleanArrayOf(true, true, false, false, false, false))
            .setLabel("年", "月", "日", "时", "分", "秒")
            .setLineSpacingMultiplier(1.2f)
            .setTextXOffset(0, 0, 0, 40, 0, -40)
            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
            .build()
            .show()

    }
}
