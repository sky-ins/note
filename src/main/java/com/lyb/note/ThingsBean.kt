package com.lyb.note

import com.chad.library.adapter.base.entity.MultiItemEntity

data class ThingsBean(var id: Int,var img: Int, var name: String, var money: String, override val itemType: Int): MultiItemEntity
{

    companion object{
        val TITLE = 1
        val MSG = 2
    }

}