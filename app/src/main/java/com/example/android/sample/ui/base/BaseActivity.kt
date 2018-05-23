package com.example.android.sample.ui.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.android.sample.R
import com.example.android.sample.app.App
import kotlinx.android.synthetic.main.toolbar.*

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private var mHasActionbar : Boolean = true

    protected fun getApplicationComponent() = (application as App).getAppComponent()

    protected open fun setupActivityComponent() {
        // Implement in child class
    }

    protected open fun hostFragment() : BaseFragment? {
        // Implement in child class
        return null
    }

    protected fun addFragment(baseFragment: BaseFragment, containerId : Int? = null) {
        val fm = supportFragmentManager
        val tf = fm.beginTransaction()

        if (containerId == null) {
            tf.add(R.id.container, baseFragment, baseFragment.javaClass.name)
        }
        else {
            tf.add(containerId, baseFragment, baseFragment.javaClass.name)
        }
        tf.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupActivityComponent()

        var hostFragment = hostFragment()
        if (hostFragment != null) {
            setContentView(R.layout.activity_base)
            this.toolbar.visibility = View.GONE
        }

        if (savedInstanceState == null && hostFragment != null) {
            addFragment(hostFragment)
        }
    }

    fun setHasActionbar(hasActionbar : Boolean) {
        mHasActionbar = hasActionbar

        if (mHasActionbar) {
            setSupportActionBar(toolbar)
            toolbar.visibility = View.VISIBLE
        }
        else {
            toolbar.visibility = View.GONE
        }
    }
}