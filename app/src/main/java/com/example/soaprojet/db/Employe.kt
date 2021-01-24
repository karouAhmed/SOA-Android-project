package com.example.soaprojet.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.soaprojet.db.Employe.Companion.LOGIN
import com.example.soaprojet.db.Employe.Companion.TABLE_NAME

@Entity(
        tableName = TABLE_NAME,
        indices = [Index(value = [LOGIN], unique = true)])
data class Employe(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idEmploye") var id: Long = 0,
        @ColumnInfo(name = LOGIN) var login: String,
        @ColumnInfo(name = "pwd") var pwd: String,
        @ColumnInfo(name = "prenom") var prenom: String,
        @ColumnInfo(name = "nom") var nom: String,
        @ColumnInfo(name = "email") var email: String,

        @ColumnInfo(name = "actif") var actif: Boolean,

        @ColumnInfo(name = "valsync") var valsync: Int

) {


    companion object {
        const val TABLE_NAME = "employe"
        const val LOGIN = "login"
    }

}