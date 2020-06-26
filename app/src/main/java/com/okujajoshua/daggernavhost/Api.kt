package com.okujajoshua.daggernavhost

import com.okujajoshua.daggernavhost.data.Repo
import com.okujajoshua.daggernavhost.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<Repo>>
}