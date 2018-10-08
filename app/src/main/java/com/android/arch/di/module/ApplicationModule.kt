package com.android.arch.di.module

import android.app.Application
import com.android.arch.di.common.ApplicationScope
import com.android.arch.di.module.viewmodel.ViewModelModule
import com.android.arch.helper.AppExecutors
import com.android.arch.preferences.SharedPreferenceHelper
import dagger.Module
import dagger.Provides

@Module(includes = [(ViewModelModule::class)])
class ApplicationModule {

    @ApplicationScope
    @Provides
    internal fun provideExecutors(): AppExecutors {
        return AppExecutors()
    }

    @ApplicationScope
    @Provides
    internal fun provideSharedPreference(application: Application): SharedPreferenceHelper {
        return SharedPreferenceHelper(application)
    }
}
