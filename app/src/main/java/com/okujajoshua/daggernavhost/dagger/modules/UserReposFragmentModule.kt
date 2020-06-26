package com.okujajoshua.daggernavhost.dagger.modules

import com.okujajoshua.daggernavhost.Api
import com.okujajoshua.daggernavhost.dagger.FragmentScope
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepository
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class UserReposFragmentModule{

    @Provides
    @FragmentScope
    fun providesReposRepository(api: Api) : ReposRepository {
        return ReposRepositoryImpl(api)
    }
}