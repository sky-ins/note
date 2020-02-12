package com.lyb.note

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class ViewModeManager {

    companion object{

        private lateinit var mainViewMode : MainViewMode
        private lateinit var viewManager : ViewModeManager
        private lateinit var activity: MainActivity

        fun getInstance(activity: MainActivity) : ViewModeManager{


            mainViewMode = ViewModelProviders.of(activity).get(MainViewMode::class.java)

                synchronized(ViewModeManager::class){
                        viewManager = ViewModeManager()
                }
            return viewManager
        }

    }

    fun changeYearData(activity: MainActivity,observer: Observer<String>){
        mainViewMode.data_year.observe(activity,observer)
    }
    fun changeMonthData(activity: MainActivity,observer: Observer<String>){
        mainViewMode.data_month.observe(activity,observer)
    }

    fun setYearData(string: String){
        mainViewMode.data_year.value = string
    }

    fun setMonthData(string: String){
        mainViewMode.data_month.value = string
    }

    fun changList(activity: MainActivity,observer: Observer<List<ThingsBean>>){
        mainViewMode.list.observe(activity,observer)

    }
    fun setList(list: List<ThingsBean>){
        mainViewMode.list.value = list
    }

}