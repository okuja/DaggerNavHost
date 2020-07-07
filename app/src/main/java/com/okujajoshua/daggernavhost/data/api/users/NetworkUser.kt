package com.okujajoshua.daggernavhost.data.api.users

import com.google.gson.annotations.SerializedName
import com.okujajoshua.daggernavhost.data.database.user.User

data class NetworkUser(
    @SerializedName("login") val login: String,
    @SerializedName("name") val name: String,
    @SerializedName("public_repos") val repos: Int
)

fun NetworkUser.asDatabaseUser() : User {
    return User(this.login,this.name,this.repos)
}