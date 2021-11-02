package com.example.week7_tasktimer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week7_tasktimer.models.Tasks
import kotlinx.android.synthetic.main.item_row.view.*


class RV_Adapter (val activity: ViewTask, private val task1:List<Tasks>): RecyclerView.Adapter<RV_Adapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val userId = task1[position].id
        val name = task1[position].name
        val description = task1[position].description



        holder.itemView.apply {
            text_View.text = "$name \n $description"

            text_View.setOnClickListener {
                Toast.makeText(activity, "Data Save Successfully!", Toast.LENGTH_SHORT).show()

            }
            // var myDBRoom= TaskDatabase.getInstance(activity)


        }

    }

fun taskTimer(){

}



    override fun getItemCount() = task1.size
}



