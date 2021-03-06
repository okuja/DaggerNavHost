package com.okujajoshua.daggernavhost

import android.app.Application
import com.okujajoshua.daggernavhost.dagger.AppComponent
import com.okujajoshua.daggernavhost.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(),HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>



    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)


//        appComponent = DaggerAppComponent
//            .builder()
//            .build()
//
//        appComponent.inject(this)

    }
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
//lateinit var appComponent: AppComponent