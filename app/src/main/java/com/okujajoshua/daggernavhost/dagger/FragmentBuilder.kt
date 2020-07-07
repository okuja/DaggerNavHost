package com.okujajoshua.daggernavhost.dagger

//import com.okujajoshua.daggernavhost.dagger.modules.UserDetailsFragmentModule
//import com.okujajoshua.daggernavhost.dagger.modules.UserReposFragmentModule
import com.okujajoshua.daggernavhost.ui.repos.UserReposFragment
import com.okujajoshua.daggernavhost.ui.userdetails.UserDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder{

//    @FragmentScope
//    @ContributesAndroidInjector(modules=[(UserDetailsFragmentModule::class)])
//    abstract fun contributeUserDetailsFragment(): UserDetailsFragment
//
//    @FragmentScope
//    @ContributesAndroidInjector(modules=[(UserReposFragmentModule::class)])
//    abstract fun contributeUserReposFragment(): UserReposFragment


    @ContributesAndroidInjector
    abstract fun contributeUserDetailsFragment(): UserDetailsFragment


    @ContributesAndroidInjector
    abstract fun contributeUserReposFragment(): UserReposFragment
}