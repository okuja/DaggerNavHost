package com.okujajoshua.daggernavhost.ui.userdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class UserDetailsViewModelFactory @Inject constructor(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            return UserDetailsViewModel(
                userRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}