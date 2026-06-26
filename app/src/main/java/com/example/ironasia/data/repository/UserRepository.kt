package com.example.ironasia.data.repository

import com.example.ironasia.data.repository.model.cityResponse.CityResponse
import com.example.ironasia.data.repository.model.userResponse.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(): Flow<UserResponse>
    suspend fun getAllCity(): Flow<CityResponse>
}