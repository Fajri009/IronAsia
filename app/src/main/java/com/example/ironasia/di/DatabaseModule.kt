package com.example.ironasia.di

import android.content.Context
import androidx.room.Room
import com.example.ironasia.data.repository.DbRepository
import com.example.ironasia.data.room.CityDao
import com.example.ironasia.data.room.IronAsiaDatabase
import com.example.ironasia.data.room.RepositoryDb
import com.example.ironasia.data.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providesUserDao(db: IronAsiaDatabase): UserDao = db.userDao()

    @Provides
    fun providesCityDao(db: IronAsiaDatabase): CityDao = db.cityDao()

    @Provides
    @Singleton
    fun provideDbRepository(
        userDao: UserDao,
        cityDao: CityDao
    ): DbRepository = RepositoryDb(userDao, cityDao)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): IronAsiaDatabase =
        Room.databaseBuilder(context, IronAsiaDatabase::class.java, "iron_asia_database")
            .fallbackToDestructiveMigration(false)
            .build()
}