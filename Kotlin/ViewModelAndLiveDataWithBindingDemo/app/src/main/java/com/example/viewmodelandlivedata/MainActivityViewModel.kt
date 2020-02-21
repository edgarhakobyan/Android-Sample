package com.example.viewmodelandlivedata

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(starterTotal: Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int> get() = total

    @Bindable
    val inputText = MutableLiveData<String>()

    init {
        total.value = starterTotal
    }

    fun setTotal() {
        var intInput = 0
        if (!inputText.value.isNullOrEmpty()) {
            intInput = inputText.value!!.toInt()
        }
        total.value = (total.value)?.plus(intInput)
    }
}