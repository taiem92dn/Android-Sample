package com.example.android.sample.ui.base

import android.content.Context

interface IBaseView {

    fun showLoading()

    fun hideLoading()

    fun getContext() : Context
}