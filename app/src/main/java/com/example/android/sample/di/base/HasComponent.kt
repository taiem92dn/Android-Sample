package com.example.android.sample.di.base

interface HasComponent<C> {
    fun getComponent() :C
}