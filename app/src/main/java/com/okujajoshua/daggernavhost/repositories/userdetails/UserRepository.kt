package com.okujajoshua.daggernavhost.repositories.userdetails

import androidx.lifecycle.LiveData
import com.okujajoshua.daggernavhost.data.database.user.User
import com.okujajoshua.daggernavhost.data.Result



interface UserRepository {

    fun getUser(username: String): LiveData<Result<User>>
}