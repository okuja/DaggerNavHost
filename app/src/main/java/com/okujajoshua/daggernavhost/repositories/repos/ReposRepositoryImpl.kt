package com.okujajoshua.daggernavhost.repositories.repos


import com.okujajoshua.daggernavhost.data.api.remotedatasource.ReposRemoteDataSource
import com.okujajoshua.daggernavhost.data.api.repos.asDatabaseRepo
import com.okujajoshua.daggernavhost.data.database.repos.RepoDao
import com.okujajoshua.daggernavhost.data.resultLiveData

class ReposRepositoryImpl(
    private val dao: RepoDao,
    private val remoteSource: ReposRemoteDataSource) :
    ReposRepository {

    override fun getRepos(username: String) = resultLiveData(
        databaseQuery = { dao.getRepos(username) },
        networkCall = { remoteSource.fetchData(username) },
        saveCallResult = { dao.insertAll(it.asDatabaseRepo(username)) }
    )
}