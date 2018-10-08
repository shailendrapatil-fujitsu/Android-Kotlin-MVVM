package com.android.arch.base.fragment

/**
 * Created by PatilShai on 1/31/2018.
 */

interface FragmentUiTransaction {
    fun onFragmentBackPress(): Boolean

    fun onFragmentInteractionRequired(): Boolean
}
