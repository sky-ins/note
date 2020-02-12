package com.lyb.note

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyb.note.databinding.ItemBinding


class RvAdapter(list: MutableList<ThingsBean>) : BaseQuickAdapter<ThingsBean,BaseViewHolder>(R.layout.item,list) {



    override fun convert(helper: BaseViewHolder, item: ThingsBean?) {
        if (item == null){
            return
        }

        var binding = helper.getBinding<ItemBinding>()
        binding?.things = item
        binding?.executePendingBindings()
    }



    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemBinding>(viewHolder.itemView)
    }




}