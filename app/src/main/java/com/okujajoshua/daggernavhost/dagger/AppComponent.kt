package com.okujajoshua.daggernavhost.dagger

import com.okujajoshua.daggernavhost.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class
    ]
)
interface AppComponent {
    fun inject(app: App)
}