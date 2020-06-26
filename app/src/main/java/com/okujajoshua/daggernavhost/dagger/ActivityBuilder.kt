package com.okujajoshua.daggernavhost.dagger

import com.okujajoshua.daggernavhost.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}

