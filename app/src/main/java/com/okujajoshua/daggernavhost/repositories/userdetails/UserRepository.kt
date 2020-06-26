package com.okujajoshua.daggernavhost.repositories.userdetails

import com.okujajoshua.daggernavhost.data.User


interface UserRepository {

    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)
}