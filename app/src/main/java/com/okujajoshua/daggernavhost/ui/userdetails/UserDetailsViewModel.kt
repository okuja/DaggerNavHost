package com.okujajoshua.daggernavhost.ui.userdetails

import androidx.lifecycle.ViewModel
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository
import javax.inject.Inject

class UserDetailsViewModel (private val userRepository: UserRepository) : ViewModel() {

    val searchUser = { username:String->userRepository.getUser(username) }

}