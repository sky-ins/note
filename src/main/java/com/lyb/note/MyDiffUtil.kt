package com.lyb.note

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil : DiffUtil.Callback() {

    private var oldList = mutableListOf<ThingsBean>()
    private var newList = mutableListOf<ThingsBean>()
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].id == newList[newItemPosition].id

    }

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]


    }

}