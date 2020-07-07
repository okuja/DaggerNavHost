package com.okujajoshua.daggernavhost.data.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the LegoTheme class.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user_table where login = :login_name")
    fun getUser(login_name:String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}
