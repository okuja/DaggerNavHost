package com.okujajoshua.daggernavhost.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.okujajoshua.daggernavhost.data.database.repos.Repo
import com.okujajoshua.daggernavhost.data.database.repos.RepoDao
import com.okujajoshua.daggernavhost.data.database.user.User
import com.okujajoshua.daggernavhost.data.database.user.UserDao

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Repo::class,User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun repoDao(): RepoDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
}