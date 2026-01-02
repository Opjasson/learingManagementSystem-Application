package com.example.educationapplication.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.MainViewModal.ShowLessonViewModal
import com.example.educationapplication.R
import com.example.educationapplication.databinding.ActivityShowLessonBinding

class ShowLessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowLessonBinding
    private val viewModal: ShowLessonViewModal by viewModels()
    private val taskAdapter = TaskAdapter(mutableListOf())

//    variable put extra
    private var id: Long = 0
    private var title: String = ""


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

        getBundles()
        initShowTask()
    }

    fun initShowTask() {
        //            Put value name lesson
        binding.apply {
            nameLesson.text = title
            loadTask.visibility = View.VISIBLE

            backBtn.setOnClickListener { finish() }
        }

        binding.taskView.layoutManager = LinearLayoutManager(this)
        binding.taskView.adapter = taskAdapter

        viewModal.searchResult.observe(this){
            data ->
            taskAdapter.setData(data)
            binding.loadTask.visibility = View.GONE
        }
        viewModal.loadData(id)
    }

    private fun getBundles() {
        //            Get context from put extra
        id = intent.getLongExtra("id",0)!!
        title = intent.getStringExtra("title")!!
    }

}