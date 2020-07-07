package com.okujajoshua.daggernavhost.data.database.repos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo_table")
data class Repo(
    @PrimaryKey
    @ColumnInfo(name = "fullname")
    val fullname: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "owner")
    val owner: String

)