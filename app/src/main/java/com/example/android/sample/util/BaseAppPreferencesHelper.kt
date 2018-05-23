package com.example.android.sample.util

import com.example.android.sample.util.security.ObscuredSharedPreferences
import com.example.android.sample.util.security.SecurityUtil


open class BaseAppPreferencesHelper {

    companion object {

        val PREF_FIRST_USE_APP : String = SecurityUtil.sha256("PREF_FIRST_USE_APP")

    }

    private val mSharedPreferences : ObscuredSharedPreferences

    private var mFirstUseApp : Boolean = false
        set(value) {
            field = value
            mSharedPreferences.edit().putBoolean(PREF_FIRST_USE_APP, mFirstUseApp).commit()
        }

    constructor(sharedPreferences: ObscuredSharedPreferences) {
        mSharedPreferences = sharedPreferences

        mFirstUseApp = mSharedPreferences.getBoolean(PREF_FIRST_USE_APP, true)
    }

    fun isFirstUseApp() = mFirstUseApp
}