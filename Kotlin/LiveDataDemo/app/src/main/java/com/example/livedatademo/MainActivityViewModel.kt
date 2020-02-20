package com.example.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(starterTotal: Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int> get() = total

    init {
        total.value = starterTotal
    }

    fun setTotal(input: Int) {
        total.value = (total.value)?.plus(input)
    }
}