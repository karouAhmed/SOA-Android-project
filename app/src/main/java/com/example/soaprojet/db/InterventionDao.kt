package com.example.soaprojet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface InterventionDao {
    @Query("SELECT * FROM intervention WHERE titre = :titre LIMIT 1")
    suspend fun findInterventionByTitre(titre: String): Intervention?

    @Query("SELECT * FROM intervention")
    suspend fun findInterventions(): List<Intervention>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(intervention: Intervention): Long

    @Query("DELETE FROM intervention")
    suspend fun deleteAll()

    @Query("UPDATE intervention SET validee = :valide WHERE idIntervention = :id")
    suspend fun updateValidation(valide: Boolean, id: Long)

}