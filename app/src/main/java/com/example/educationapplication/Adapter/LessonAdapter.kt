package com.example.educationapplication.Adapter

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapplication.Activity.ShowLessonActivity
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
            val item = items[position]

            holder.binding.apply {
                nameTxt.text = item.name
                lessonId.visibility = View.GONE
                descTxt.text = item.description
            }

            holder.itemView.setOnClickListener {
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(context, ShowLessonActivity::class.java).apply {
                        putExtra("id", item.lessonId)
                        putExtra("title", item.name)
                    }
                    ContextCompat.startActivity(context, intent, null)
                }, 500)
            }
        }
        override fun getItemCount(): Int = items.size

        fun updateData(newItems: MutableList<LessonModal>) {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }
    }


