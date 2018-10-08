package com.android.arch.base.activity


import android.support.annotation.IdRes
import android.support.v4.app.Fragment

abstract class AbstractChildFragmentNavigationController protected constructor(fragment: Fragment) : BaseNavigationController(fragment.childFragmentManager) {
    private lateinit var fragmentToChange: Fragment
    private var isBackStack: Boolean = false

    protected fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        this.fragmentToChange = fragment
        this.isBackStack = addToBackStack
    }

    protected fun updateFragment() {
        val backStackName = this.fragmentToChange.javaClass.simpleName

        val isPop = fragmentManager.popBackStackImmediate(backStackName, 0)
        if (!isPop && fragmentManager.findFragmentByTag(backStackName) == null) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(provideContainerId(), this.fragmentToChange, backStackName)
            if (this.isBackStack) {
                fragmentTransaction.addToBackStack(backStackName)
            }
            fragmentTransaction.commit()
        }
        this.isBackStack = false
    }


    @IdRes
    protected abstract fun provideContainerId(): Int
}
