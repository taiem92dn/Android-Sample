package com.example.android.sample.di.component

import com.example.android.sample.app.AppPreferencesHelper
import com.example.android.sample.di.module.AppModule
import com.example.android.sample.ui.login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AppModule::class
])
interface AppComponent {
    fun appPreferencesHelper() : AppPreferencesHelper

    fun inject(loginActivity: LoginActivity)
}