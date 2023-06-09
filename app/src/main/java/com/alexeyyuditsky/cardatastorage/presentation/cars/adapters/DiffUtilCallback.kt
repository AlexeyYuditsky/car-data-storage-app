package com.alexeyyuditsky.cardatastorage.presentation.cars.adapters

import androidx.recyclerview.widget.DiffUtil
import com.alexeyyuditsky.cardatastorage.presentation.cars.CarUi

class DiffUtilCallback(
    private val oldList: List<CarUi>,
    private val newList: List<CarUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].same(newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].sameContent(newList[newItemPosition])
    }
}