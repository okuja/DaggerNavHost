package com.okujajoshua.daggernavhost.ui.userdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okujajoshua.daggernavhost.data.User
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository

class UserDetailsViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String>
        get() = _fullName

    private val _repos = MutableLiveData<Int>()
    val repos: LiveData<Int>
        get() = _repos

    //shall be used in coroutine functions
    fun searchUser(username: String) {
        Log.d("In Search User",username)
        userRepository.getUser(
            username,
            { user -> _user.value = user
                _fullName.value = user.name
                _repos.value = user.repos
                Log.d("In get user",fullName.value)
            },
            { t -> Log.e("UserDetailsViewModel", "onFailure: ", t) }
        )
    }
}