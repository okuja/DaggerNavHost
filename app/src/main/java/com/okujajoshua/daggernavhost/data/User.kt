package com.okujajoshua.daggernavhost.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("public_repos") val repos: Int
)