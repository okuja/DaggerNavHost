package com.okujajoshua.daggernavhost.repositories.repos

import androidx.lifecycle.LiveData
import com.okujajoshua.daggernavhost.data.database.repos.Repo
import com.okujajoshua.daggernavhost.data.Result


interface ReposRepository {

    fun getRepos(username: String):LiveData<Result<List<Repo>>>
}