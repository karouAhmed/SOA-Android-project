package com.example.soaprojet.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
        tableName = Intervention.TABLE_NAME,
        indices = [Index(value = [Intervention.ID], unique = true)])
data class Intervention(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = ID) var id: Long = 0,
        @ColumnInfo(name = "titre") var titre: String,
        @ColumnInfo(name = "client") var client: String,
        @ColumnInfo(name = "adrClient") var adrClient: String,
        @ColumnInfo(name = "validee") var validee: Boolean,
        @ColumnInfo(name = "dateValidation") var dateValidation: String,
        @ColumnInfo(name = "dateDebut") var dateDebut: String,
        @ColumnInfo(name = "dateFin") var dateFin: String


) {
    companion object {
        const val TABLE_NAME = "intervention"
        const val ID = "idIntervention"
    }
}