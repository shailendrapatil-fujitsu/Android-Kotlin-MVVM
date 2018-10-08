package com.android.arch.di.component


import android.app.Application
import com.android.arch.App
import com.android.arch.di.common.ApplicationScope
import com.android.arch.di.module.ApplicationModule
import com.android.arch.di.module.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
