package com.okujajoshua.daggernavhost.repositories.userdetails


import com.okujajoshua.daggernavhost.data.api.remotedatasource.UserRemoteDataSource
import com.okujajoshua.daggernavhost.data.api.users.asDatabaseUser
import com.okujajoshua.daggernavhost.data.database.user.UserDao
import com.okujajoshua.daggernavhost.data.resultLiveData

class UserRepositoryImpl(
    private val dao: UserDao,
    private val remoteSource: UserRemoteDataSource
) :
    UserRepository {

    override fun getUser(username: String) = resultLiveData(
        databaseQuery = { dao.getUser(username) },
        networkCall = { remoteSource.fetchData(username) },
        saveCallResult = { dao.insert(it.asDatabaseUser()) }
    )

}