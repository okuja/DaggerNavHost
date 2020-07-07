package com.okujajoshua.daggernavhost.data.api.repos

import com.google.gson.annotations.SerializedName
import com.okujajoshua.daggernavhost.data.database.repos.Repo

data class NetworkRepo(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String
)

fun List<NetworkRepo>.asDatabaseRepo(owner:String) : List<Repo>{
    return map{
        Repo(
            owner = owner,
            fullname = it.full_name,
            name = it.name
        )
    }
}