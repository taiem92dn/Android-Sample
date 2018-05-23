package com.example.android.sample.di.component

import com.example.android.sample.app.AppPreferencesHelper
import com.example.android.sample.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AppModule::class
])
interface AppComponent {
    fun appPreferencesHelper() : AppPreferencesHelper

}