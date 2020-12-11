package com.example.lpihubapp

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AllListAdapter( private val list: ArrayList<All>,
                      private val context: Context) : RecyclerView.Adapter<AllListAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

                fun bindItem(all: All) {
                        var name: TextView = itemView.findViewById(R.id.name) as TextView
                        var message: TextView = itemView.findViewById(R.id.email) as TextView
                        var image: ImageView = itemView.findViewById(R.id.profile_picture) as ImageView

                        name.text = all.name
                        message.text = all.email
                        image.setImageResource(all.image)


                        itemView.setOnClickListener {


                        }

                }}


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view =
                        LayoutInflater.from(context).inflate(R.layout.allitem, parent, false)

                return ViewHolder(view)
        }


        override fun getItemCount(): Int {
                return list.size
        }



        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder?.bindItem(list[position])
        }


}

