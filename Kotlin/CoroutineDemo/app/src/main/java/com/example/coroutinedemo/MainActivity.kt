package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        View Model scope
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        commented because of using live data
//        mainActivityViewModel.getUserData()
        mainActivityViewModel.users.observe(this, Observer {myUsers->
            myUsers.forEach {
                Log.i("MyTag"," name is ${it.name}")
            }

        })
//        View Model scope

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

//    view on UI
    private suspend fun downloadUserData() {
        for (i in 1..50000) {
            withContext(Dispatchers.Main) {
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }

//    using in background
//    private fun downloadUserData() {
//        for (i in 1..50000) {
//            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
//        }
//    }
}
