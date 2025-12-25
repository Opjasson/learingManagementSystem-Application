package com.example.educationapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.databinding.ViewholderLessonBinding

class LessonAdapter(val items: MutableList<LessonModal>):
    RecyclerView.Adapter<LessonAdapter.Viewholder>(){

        private lateinit var context: Context

        inner class Viewholder(val binding: ViewholderLessonBinding):
        RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonAdapter.Viewholder {
            context= parent.context
            val binding = ViewholderLessonBinding.inflate(LayoutInflater.from(context), parent, false)
            return Viewholder(binding)
        }

        override fun onBindViewHolder(holder: LessonAdapter.Viewholder, position: Int) {
            holder.binding.nameTxt.text = items[position].name
            holder.binding.descTxt.text = items[position].description
        }
        override fun getItemCount(): Int = items.size

        fun updateData(newItems: MutableList<LessonModal>) {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }
    }


