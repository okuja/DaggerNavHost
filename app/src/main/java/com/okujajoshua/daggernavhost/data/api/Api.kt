package com.okujajoshua.daggernavhost.data.api

import com.okujajoshua.daggernavhost.data.api.repos.NetworkRepo
import com.okujajoshua.daggernavhost.data.api.users.NetworkUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("users/{user}")
    suspend fun getUser(@Path("user") user: String): Response<NetworkUser>

    @GET("users/{user}/repos")
    suspend fun getRepos(@Path("user") user: String): Response<List<NetworkRepo>>
}