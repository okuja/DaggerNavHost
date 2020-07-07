package com.okujajoshua.daggernavhost.dagger


import android.app.Application
import androidx.room.Room
import com.okujajoshua.daggernavhost.App
import com.okujajoshua.daggernavhost.data.api.Api
import com.okujajoshua.daggernavhost.data.api.remotedatasource.ReposRemoteDataSource
import com.okujajoshua.daggernavhost.data.api.remotedatasource.UserRemoteDataSource
import com.okujajoshua.daggernavhost.data.database.AppDatabase
import com.okujajoshua.daggernavhost.data.database.repos.RepoDao
import com.okujajoshua.daggernavhost.data.database.user.UserDao
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepository
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepositoryImpl
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    /** API */
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideReposRemoteDataSource(api: Api)
            = ReposRemoteDataSource(api)

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(api: Api)
            = UserRemoteDataSource(api)

    /** Database */

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase{
        return Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "App-Database")
            .build()
    }


    @Singleton
    @Provides
    fun provideRepoDao(db: AppDatabase) = db.repoDao()


    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()

    /** Repositories */
    @Singleton
    @Provides
    fun providesUserRepository(userDao:UserDao,userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(userDao,userRemoteDataSource)
    }

    @Singleton
    @Provides
    fun providesReposRepository(dao: RepoDao, remoteDataSource: ReposRemoteDataSource): ReposRepository {
        return ReposRepositoryImpl(dao,remoteDataSource)
    }
}