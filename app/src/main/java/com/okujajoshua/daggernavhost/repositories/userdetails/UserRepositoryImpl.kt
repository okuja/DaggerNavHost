package com.okujajoshua.daggernavhost.repositories.userdetails


import com.okujajoshua.daggernavhost.Api
import com.okujajoshua.daggernavhost.data.User
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepositoryImpl(private val api: Api) :
    UserRepository {

    override fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    onSuccess.invoke(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }
        })
    }
}