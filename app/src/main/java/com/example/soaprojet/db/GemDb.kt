package com.example.soaprojet.db

/*
@Database(entities = [Employe::class,Intervention::class], version = 1)

abstract class GemDb : RoomDatabase(){

    abstract fun EmployeDao(): EmployeDao
    abstract fun InterventionDao(): InterventionDao

    companion object {
        private var INSTANCE: GemDb? = null
        private const val DB_NAME = "gem.db"

        fun getDatabase(context: Context): GemDb {
            if (INSTANCE == null) {
                synchronized(GemDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, GemDb::class.java, DB_NAME)
                            //.allowMainThreadQueries() // Uncomment if you don't want to use RxJava or coroutines just yet (blocks UI thread)
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    Log.d("GemDb", "populating with data...")
                                    GlobalScope.launch(Dispatchers.IO) { rePopulateDb(INSTANCE) }
                                }
                            }).build()
                    }
                }
            }

            return INSTANCE!!
        }
    }
}
*/