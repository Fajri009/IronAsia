package com.example.ironasia.data.remote.api

import com.example.ironasia.data.repository.model.cityResponse.CityResponse
import com.example.ironasia.data.repository.model.userResponse.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("user")
    suspend fun getUser(
        @Query("name") name: String = "",
        @Query("city") city: String = ""
    ): UserResponse

    @GET("city")
    suspend fun getAllCity(): CityResponse
}