package com.android.arch.base.fragment


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.View
import com.android.arch.base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractBaseDialogFragment<VM : AbstractViewModel> : DialogFragment(), InjectableFragment, FragmentUiTransaction {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected var viewModel: VM? = null

    protected abstract val viewModelType: Class<VM>

    @get:LayoutRes
    protected abstract val layout: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType)

    }

    override fun onFragmentBackPress(): Boolean {
        return false
    }

    override fun onFragmentInteractionRequired(): Boolean {
        return false
    }

}
