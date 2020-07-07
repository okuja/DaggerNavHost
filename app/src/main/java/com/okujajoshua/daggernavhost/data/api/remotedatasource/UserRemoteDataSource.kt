package com.okujajoshua.daggernavhost.data.api.remotedatasource

import com.okujajoshua.daggernavhost.data.api.Api
import com.okujajoshua.daggernavhost.data.api.BaseDataSource
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val api: Api) : BaseDataSource(){

    suspend fun fetchData(username: String) = getResult { api.getUser(username) }

}