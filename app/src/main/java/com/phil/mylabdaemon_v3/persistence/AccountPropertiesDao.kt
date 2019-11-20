package com.phil.mylabdaemon_v3.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.phil.mylabdaemon_v3.models.AccountProperties

@Dao
interface AccountPropertiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(accountProperties: AccountProperties):Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnore(accountProperties: AccountProperties):Long

    @Query("SELECT * from account_properties where pk = :pk")
    fun searchByPk(pk: Int): AccountProperties?

    @Query("SELECT * from account_properties where email = :email")
    fun searchByPk(email: String): AccountProperties?

}