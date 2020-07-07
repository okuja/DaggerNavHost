package com.okujajoshua.daggernavhost.data.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey
    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "number_of_repos")
    val number_of_repos: Int

)