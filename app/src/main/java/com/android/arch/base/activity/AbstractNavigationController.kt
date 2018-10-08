package com.android.arch.base.activity


import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class AbstractNavigationController protected constructor(val activity: AppCompatActivity, @IdRes private val containerId: Int) : BaseNavigationController(activity.supportFragmentManager) {
    private var fragmentToChange: Fragment? = null
    private var isBackStack: Boolean = false

    protected fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        this.fragmentToChange = fragment
        this.isBackStack = addToBackStack
    }

    protected fun updateFragment() {
        if (this.fragmentToChange == null) {
            return
        }
        val backStackName = this.fragmentToChange!!.javaClass.simpleName

        val isPop = fragmentManager.popBackStackImmediate(backStackName, 0)
        if (!isPop /*&& getFragmentManager().findFragmentByTag(backStackName) == null*/) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(containerId, this.fragmentToChange!!, backStackName)
            if (this.isBackStack) {
                fragmentTransaction.addToBackStack(backStackName)
            }
            fragmentTransaction.commit()
        }
        this.fragmentToChange = null
        this.isBackStack = false
    }

}
