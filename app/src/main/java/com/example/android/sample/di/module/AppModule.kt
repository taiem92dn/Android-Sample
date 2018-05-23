package com.example.android.sample.di.module

import android.app.Application
import android.content.Context
import com.example.android.sample.R
import com.example.android.sample.app.AppPreferencesHelper
import com.example.android.sample.util.security.ObscuredSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class  AppModule {
    val mApplication: Application

    constructor(application: Application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    fun provideApplicationContext() = mApplication

    @Provides
    @Singleton
    fun provideObscuredSharedPreferences()
            = ObscuredSharedPreferences(this.mApplication, mApplication.getSharedPreferences(mApplication.getString(R.string.app_name), Context.MODE_PRIVATE))

    @Provides
    @Singleton
    fun provideAppPreferences(sharedPreferences: ObscuredSharedPreferences)
            = AppPreferencesHelper(sharedPreferences)
}