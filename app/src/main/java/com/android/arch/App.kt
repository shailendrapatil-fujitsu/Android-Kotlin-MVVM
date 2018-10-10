package com.android.arch

import android.app.Activity
import android.app.Service
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.android.arch.di.AppInjector
import com.android.arch.ui.dashboard.DashboardActivity
import com.android.arch.ui.signin.AppLoginActivity
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager
import com.salesforce.androidsdk.ui.LoginActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingAndroidServiceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        AppInjector.initialize(this)

        //SalesforceSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(), MainActivity1.class);

        /*SmartSyncSDKManager.initNative(getApplicationContext(), new KeyImpl(),
                MainActivity.class);*/

        /*SmartSyncSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(),
                com.us.syngenta.goldenharwest.ui.MainActivity.class);*/


        SmartSyncSDKManager.initNative(applicationContext, DashboardActivity::class.java, AppLoginActivity::class.java)
//        SmartSyncSDKManager.initNative(getApplicationContext(),
//                com.us.syngenta.goldenharwest.ui.DashboardActivity.class, LoginActivity.class);
        /*
         * Un-comment the line below to enable push notifications in this app.
         * Replace 'pnInterface' with your implementation of 'PushNotificationInterface'.
         * Add your Google package ID in 'bootonfig.xml', as the value
         * for the key 'androidPushNotificationClientId'.
         */
        // SalesforceSDKManager.getInstance().setPushNotificationReceiver(pnInterface);
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service>? {
        return dispatchingAndroidServiceInjector
    }
}
