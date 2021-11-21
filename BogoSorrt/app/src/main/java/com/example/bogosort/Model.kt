package com.example.bogosort

import kotlin.collections.ArrayList

class Model {
    var dataList : ArrayList<Int> = ArrayList()

    public fun reset(): ArrayList<Int> {
        dataList.clear()
        dataList.addAll(arrayOf(1,2,3,4,5,6,7))
        return dataList
    }
}