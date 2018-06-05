package com.example.android.sample.ui.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.sample.app.App

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {


    protected fun getApplicationComponent() = (application as App).getAppComponent()

    protected open fun setupActivityComponent() {
        // Implement in child class
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupActivityComponent()
    }

}