package com.example.soaprojet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeDao {

    @Query("SELECT * FROM employe WHERE login = :login LIMIT 1")
    suspend fun findEmployeLoginByLogin(login: String): Employe?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employe: Employe): Long

    @Query("DELETE FROM employe")
    suspend fun deleteAll()
}