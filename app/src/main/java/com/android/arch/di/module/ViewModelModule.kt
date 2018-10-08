package com.android.arch.di.module

import android.arch.lifecycle.ViewModelProvider
import com.android.arch.base.viewmodel.BaseViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory

}
