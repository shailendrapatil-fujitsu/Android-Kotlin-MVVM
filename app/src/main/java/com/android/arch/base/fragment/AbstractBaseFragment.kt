package com.android.arch.base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.arch.base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractBaseFragment<VM : AbstractViewModel> : Fragment(), InjectableFragment, FragmentUiTransaction {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    internal lateinit var viewModel: VM
    protected abstract val viewModelType: Class<VM>

    @get:LayoutRes
    protected abstract val layout: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layout, container, false)
    }

    override fun onFragmentBackPress(): Boolean {
        return false
    }

    override fun onFragmentInteractionRequired(): Boolean {
        return false
    }

}
