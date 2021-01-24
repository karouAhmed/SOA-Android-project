package com.example.soaprojet.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
        entities = [Employe::class, Intervention::class],
        version = 5, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeDao(): EmployeDao
    abstract fun interventionDao(): InterventionDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                AppDatabase::class.java, "gem.db")
                .fallbackToDestructiveMigration()

                .build()
    }
}