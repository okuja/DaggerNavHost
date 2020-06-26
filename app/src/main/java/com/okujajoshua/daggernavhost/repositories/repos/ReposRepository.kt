package com.okujajoshua.daggernavhost.repositories.repos

import com.okujajoshua.daggernavhost.data.Repo


interface ReposRepository {

    fun getRepos(username: String, onSuccess: (repos: List<Repo>) -> Unit, onFailure: (t: Throwable) -> Unit)
}