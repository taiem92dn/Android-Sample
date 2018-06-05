package com.example.android.sample.presenter.login

import android.os.AsyncTask
import android.text.TextUtils
import android.util.Patterns
import com.example.android.sample.presenter.IBasePresenter
import com.example.android.sample.ui.login.ILoginView
import javax.inject.Inject

class LoginPresenter @Inject constructor() : IBasePresenter<ILoginView> {

//    @Inject
//    lateinit var mContext : Context

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private var mAuthTask: UserLoginTask? = null

    var mLoginView : ILoginView ?= null


    override fun setView(viewType: ILoginView) {
        mLoginView = viewType
    }


    fun isEmailValid(email: String): Boolean {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

    override fun destroyView() {
        mLoginView = null
    }

    fun isLogging() : Boolean {
        return mAuthTask != null
    }

    fun login(email: String, password: String) {
        mAuthTask = UserLoginTask(email, password)
        mAuthTask!!.execute(null as Void?)
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    inner class UserLoginTask internal constructor(private val mEmail: String, private val mPassword: String) : AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void): Boolean? {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                return false
            }

            for (credential in DUMMY_CREDENTIALS) {
                val pieces = credential.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (pieces[0] == mEmail) {
                    // Account exists, return true if the password matches.
                    return pieces[1] == mPassword
                }
            }

            // TODO: register the new account here.
            return true
        }

        override fun onCancelled() {
            mAuthTask = null
            mLoginView?.showProgress(false)
        }

        override fun onPostExecute(success: Boolean?) {
            mAuthTask = null
            mLoginView?.showProgress(false)

            if (success!!) {
                mLoginView?.showSuccess()
            } else {
                mLoginView?.showFail()
            }
        }
    }


    companion object {
        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */
        private val DUMMY_CREDENTIALS = arrayOf("foo@example.com:hello", "bar@example.com:world")
    }
}