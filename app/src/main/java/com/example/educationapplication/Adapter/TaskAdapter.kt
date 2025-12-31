package com.example.educationapplication.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapplication.Activity.ShowLessonActivity
import com.example.educationapplication.Domain.TaskModal
import com.example.educationapplication.databinding.ViewholderLessonBinding
import com.example.educationapplication.databinding.ViewholderShowtaskBinding

class TaskAdapter(val items: MutableList<TaskModal>):
RecyclerView.Adapter<TaskAdapter.Viewholder>() {
    private lateinit var context: Context

    inner class Viewholder(val binding: ViewholderShowtaskBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.Viewholder {
        context= parent.context
        val binding = ViewholderShowtaskBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: TaskAdapter.Viewholder, position: Int) {

        holder.binding.numSoalTxt.text = (position + 1).toString()
        holder.binding.soalTxt.text = items[position].soal.trim()
        holder.binding.pil1.text = items[position].pilihan1.trim()
        holder.binding.pil2.text = items[position].pilihan2.trim()
        holder.binding.pil3.text = items[position].pilihan3.trim()
        holder.binding.pil4.text = items[position].pilihan4.trim()

    }
    override fun getItemCount(): Int = items.size

}
