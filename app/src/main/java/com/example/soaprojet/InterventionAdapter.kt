package com.example.soaprojet

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soaprojet.db.AppDatabase
import com.example.soaprojet.db.Intervention
import com.example.soaprojet.db.InterventionDao
import kotlinx.android.synthetic.main.activity_item_cell.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InterventionAdapter(private val dataList: List<Intervention>, private val listener: onItemClickListnner) : RecyclerView.Adapter<InterventionAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val titre: TextView = itemView.interventionTitleTv
        val client: TextView = itemView.interventionClientTv
        val clientAdr: TextView = itemView.adressTv
        val date: TextView = itemView.dateTv


        val validationCb: CheckBox = itemView.checkBox

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_cell, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.titre.text = currentItem.titre
        holder.client.text = currentItem.client
        holder.clientAdr.text = currentItem.adrClient
        // val dateTimeDebut = LocalDateTime.parse(currentItem.dateDebut, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //val dateTimeFin = LocalDateTime.parse(currentItem.dateFin, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        holder.date.text = "15:00 - 17:00"
        holder.validationCb.isChecked = currentItem.validee != false
        holder.validationCb.setOnClickListener {
            dataList[position].validee = holder.validationCb.isChecked
            val builder = AlertDialog.Builder(holder.itemView.context)
            if (!holder.validationCb.isChecked) {
                builder.setTitle("Décocher ?")
                builder.setMessage("Etes-vous sur de vouloir decocher cette intervention ?")
            } else {
                builder.setTitle("cocher ?")
                builder.setMessage("Etes-vous sur de vouloir cocher cette intervention ?")
            }


            builder.setNeutralButton("Annuler") { dialog, which ->

            }

            builder.setNegativeButton(android.R.string.ok) { dialog, which ->
                val db = AppDatabase(holder.itemView.context)

                GlobalScope.launch {
                    val interventionDao: InterventionDao = db.interventionDao()
                    interventionDao.updateValidation(holder.validationCb.isChecked, dataList[position].id)

                }
            }
            builder.show()

        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface onItemClickListnner {
        fun onItemClick(position: Int)
    }
}
