package com.android.arch.base.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.salesforce.androidsdk.ui.SalesforceActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class AbstractBaseDefaultSalesforceActivity : SalesforceActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

//    @JvmOverloads
//    fun updateToolbar(isBackNavigation: Boolean, title: String, toolbarActionListener: ToolbarActionListener? = null) {
//        val toolbar = findViewById<Toolbar>(R.id.toolbar) ?: return
//
//        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(isBackNavigation)
//        supportActionBar!!.setHomeButtonEnabled(true)
//
//        supportActionBar!!.title = title
//
//        toolbar.setNavigationOnClickListener {
//            if (toolbarActionListener == null) {
//                onBackPressed()
//            } else {
//                toolbarActionListener.toolbarButtonPressed()
//            }
//        }
//    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    interface ActivityUiInteraction<T> {
        val navigationController: T
    }
}
