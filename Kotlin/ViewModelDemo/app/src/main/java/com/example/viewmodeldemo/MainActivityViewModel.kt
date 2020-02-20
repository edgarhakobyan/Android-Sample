package com.example.viewmodeldemo

import androidx.lifecycle.ViewModel

class MainActivityViewModel(val starterTotal: Int) : ViewModel() {
    private var total = 0

    init {
        total = starterTotal
    }

    fun setTotal(input: Int) {
        total += input
    }

    fun getTotal(): Int {
        return total
    }
}