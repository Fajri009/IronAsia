package com.example.ironasia.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ironasia.data.repository.model.userResponse.UserResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT MAX(id) FROM user")
    suspend fun getMaxId(): Int?

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<UserResponse>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: String): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("DELETE FROM user WHERE id = :id")
    suspend fun deleteUser(id: String)
}