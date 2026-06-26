package com.example.ironasia.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ironasia.data.repository.model.cityResponse.CityResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("SELECT * FROM city")
    fun getCity(): Flow<CityResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: List<CityEntity>)
}