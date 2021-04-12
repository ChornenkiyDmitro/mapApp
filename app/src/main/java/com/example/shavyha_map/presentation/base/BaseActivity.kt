package com.example.shavyha_map.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        var currentActivity: Class<*>? = null
    }


    override fun onStart() {
        super.onStart()
        currentActivity = this::class.java
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (currentActivity == javaClass) {
            currentActivity = null
        }
        super.onDestroy()
    }
}