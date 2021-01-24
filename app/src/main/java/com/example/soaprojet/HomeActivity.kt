package com.example.soaprojet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soaprojet.db.AppDatabase
import com.example.soaprojet.db.Intervention
import com.example.soaprojet.db.InterventionDao
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), InterventionAdapter.onItemClickListnner {

    var dataList: ArrayList<Intervention> = ArrayList()
    val db = AppDatabase(this)

    private val adapter = InterventionAdapter(dataList, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initData()
        recycle_view.adapter = adapter
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.setHasFixedSize(true)
    }

    fun initData() {
        GlobalScope.launch {
            val interventionDao: InterventionDao = db.interventionDao()

            val dd = interventionDao.findInterventions()
            dataList.addAll(dd)
        }
    }

    override fun onItemClick(position: Int) {
    }
}
