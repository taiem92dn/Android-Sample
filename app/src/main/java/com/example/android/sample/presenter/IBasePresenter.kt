package com.example.android.sample.presenter

interface IBasePresenter<ViewType> {

    fun setView(viewType: ViewType)
    fun destroyView()
}