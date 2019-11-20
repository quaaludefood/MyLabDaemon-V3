package com.phil.mylabdaemon_v3.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.phil.mylabdaemon_v3.models.AuthToken

@Dao
interface AuthTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authToken: AuthToken):Long

    //nullify token on ligging out
    @Query("update auth_token set token = null where account_pk = :pk")
    fun nullifyToken(pk: Int): Int

}