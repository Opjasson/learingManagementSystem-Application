package com.example.educationapplication.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationapplication.Adapter.LessonAdapter
import com.example.educationapplication.Adapter.TaskAdapter
import com.example.educationapplication.MainViewModal.ShowLessonViewModal
import com.example.educationapplication.R
import com.example.educationapplication.databinding.ActivityShowLessonBinding

class ShowLessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowLessonBinding
    private val viewModal: ShowLessonViewModal by viewModels()
    private val taskAdapter = TaskAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShowLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initShowTask()
    }

    fun initShowTask() {
        binding.loadTask.visibility = View.VISIBLE
        val taskAdapter = TaskAdapter(mutableListOf())
        binding.taskView.adapter = taskAdapter

        viewModal.loadData{
            list ->
            binding.taskView.layoutManager = LinearLayoutManager(this)
            binding.taskView.adapter = TaskAdapter(list)
            binding.loadTask.visibility = View.GONE
        }

        binding.backBtn.setOnClickListener { finish() }
    }

}