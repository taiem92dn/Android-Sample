package com.example.android.sample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.android.sample.di.base.HasComponent

open class BaseFragment : Fragment() {

    protected fun <C> getComponent(componentType : Class<C>) : C {
        return componentType.cast((activity as HasComponent<*>).getComponent())
    }

    protected open fun onScreenVisible() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupComponent()

        onScreenVisible()
    }

    protected open fun setupComponent() {

    }


}