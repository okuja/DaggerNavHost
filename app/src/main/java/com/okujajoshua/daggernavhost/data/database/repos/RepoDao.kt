package com.okujajoshua.daggernavhost.data.database.repos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM repo_table where owner=:owner_name")
    fun getRepos(owner_name:String): LiveData<List<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<Repo>)
}