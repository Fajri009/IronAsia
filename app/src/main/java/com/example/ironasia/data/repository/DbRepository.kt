package com.example.ironasia.data.repository

import com.example.ironasia.data.repository.model.cityResponse.CityResponse
import com.example.ironasia.data.repository.model.userResponse.UserItem
import com.example.ironasia.data.repository.model.userResponse.UserResponse
import kotlinx.coroutines.flow.Flow

interface DbRepository {
    fun getUsers(): Flow<UserResponse>
    suspend fun insertUsers(users: UserResponse)
    suspend fun insertUser(user: UserItem)
    suspend fun updateUser(user: UserItem)
    suspend fun deleteUser(user: UserItem)

    fun getCity(): Flow<CityResponse>
    suspend fun insertCity(city: CityResponse)
}