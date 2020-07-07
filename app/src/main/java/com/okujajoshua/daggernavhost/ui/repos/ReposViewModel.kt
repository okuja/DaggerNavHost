package com.okujajoshua.daggernavhost.ui.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepository
import javax.inject.Inject

class ReposViewModel (private val reposRepository: ReposRepository) : ViewModel() {
    val repos = { username:String -> reposRepository.getRepos(username) }
}

@Suppress("UNCHECKED_CAST")
class ReposViewModelFactory @Inject constructor(private val reposRepository: ReposRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(reposRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel clas")
    }
}
