package com.example.soaprojet.db

/*
suspend fun rePopulateDb(database: GemDb?) {
    database?.let { db ->
        withContext(Dispatchers.IO) {
            val employeDao: EmployeDao = db.EmployeDao()
            val interventionDao: InterventionDao = db.InterventionDao()

            employeDao.deleteAll()
            val employe = Employe(email = "ahmedd@g.c",actif = true,login = "ahmed",nom = "ahmed",prenom = "karou",pwd = "ahmed",valsync = 0,id = 0)

            employeDao.insert(employe)
        }
    }
}*/