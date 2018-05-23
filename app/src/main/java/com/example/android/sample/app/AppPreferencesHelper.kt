package com.example.android.sample.app

import com.example.android.sample.util.BaseAppPreferencesHelper
import com.example.android.sample.util.security.ObscuredSharedPreferences


class AppPreferencesHelper: BaseAppPreferencesHelper {

   constructor(sharedPreferences: ObscuredSharedPreferences) : super(sharedPreferences)
}