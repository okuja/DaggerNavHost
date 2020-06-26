package com.okujajoshua.daggernavhost.ui.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggernavhost.data.Repo
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepository
import javax.inject.Inject

class ReposViewModel (private val reposRepository: ReposRepository) : ViewModel() {

    private val _repos = MutableLiveData<List<Repo>>()

    val repos: LiveData<List<Repo>>
        get() = _repos

    fun getRepos(username: String) {
        reposRepository.getRepos(
            username,
            { repositories -> _repos.value = repositories },
            { t -> Log.e("ReposViewModel", "onFailure: ", t) }
        )
    }
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
