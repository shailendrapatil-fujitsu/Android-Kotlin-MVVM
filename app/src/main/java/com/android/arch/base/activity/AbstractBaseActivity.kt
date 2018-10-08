package com.android.arch.base.activity


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import com.android.arch.base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractBaseActivity<VM : AbstractViewModel> : AbstractBaseNormalActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModelType: Class<VM>

    private var viewModel: VM? = null

    @get:LayoutRes
    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType)

    }

}
