package com.example.ironasia.data.remote

import com.example.ironasia.data.remote.api.UserApi
import com.example.ironasia.data.repository.UserRepository
import com.example.ironasia.data.repository.model.cityResponse.CityResponse
import com.example.ironasia.data.repository.model.userResponse.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRemoteDataSource(
    private val userApi: UserApi
): UserRepository {
    override suspend fun getUser(): Flow<UserResponse> =
        flow {
            val response = userApi.getUser()

            emit(response)
        }

    override suspend fun getAllCity(): Flow<CityResponse> =
        flow {
            val response = userApi.getAllCity()

            emit(response)
        }
}