package com.example.soaprojet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.soaprojet.db.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utilities.setupUI(this, findViewById(R.id.maind))
        val db = AppDatabase(this)

        GlobalScope.launch {
            val employeDao: EmployeDao = db.employeDao()
            val interventionDao: InterventionDao = db.interventionDao()
            employeDao.deleteAll()
            interventionDao.deleteAll()
            val employe = Employe(
                    email = "ahmedd@g.c",
                    actif = true,
                    login = "ahmed",
                    nom = "ahmed",
                    prenom = "karou",
                    pwd = "ahmed",
                    valsync = 0
            )
            val intervention = Intervention(
                    titre = "intervention1",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "clinet1"
            )
            val intervention2 = Intervention(
                    titre = "intervention2",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "clinet2"
            )
            val intervention3 = Intervention(
                    titre = "intervention3",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "clientt3"
            )
            val intervention4 = Intervention(
                    titre = "intervention4",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "client4"
            )
            val intervention5 = Intervention(
                    titre = "intervention5",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "client5"
            )
            val intervention6 = Intervention(
                    titre = "intervention6",
                    dateValidation = LocalDateTime.now().toString(),
                    validee = true,
                    dateDebut = LocalDateTime.now().toString(),
                    dateFin = LocalDateTime.now().toString(),
                    adrClient = "ariana", client = "clinet6"
            )



            interventionDao.insert(intervention)
            interventionDao.insert(intervention2)
            interventionDao.insert(intervention3)
            interventionDao.insert(intervention4)
            interventionDao.insert(intervention5)
            interventionDao.insert(intervention6)
            employeDao.insert(employe)

        }
        cnxBtn.setOnClickListener {
            val db = AppDatabase(this)

            var employe: Employe
            GlobalScope.launch {
                val employeDao: EmployeDao = db.employeDao()
                if (employeDao.findEmployeLoginByLogin(loginTv.text.toString()) != null) {
                    employe = employeDao.findEmployeLoginByLogin(loginTv.text.toString())!!
                    if (employe.pwd == pwdTv.text.toString()) {
                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    } else {
                        Toast.makeText(this@MainActivity, "invalide login or password !!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "invalide login or password !!", Toast.LENGTH_SHORT).show()

                }
            }


        }

    }

    fun isValideUser(): Boolean {

        return false
    }
}