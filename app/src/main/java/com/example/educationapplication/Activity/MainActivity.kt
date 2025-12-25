package com.example.educationapplication.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationapplication.Adapter.LessonAdapter
import com.example.educationapplication.Domain.LessonModal
import com.example.educationapplication.MainViewModal.MainViewModal
import com.example.educationapplication.R
import com.example.educationapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModal= MainViewModal()

    private val lessonAdapter = LessonAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initSearchField()
        initLesson()
    }

    private fun initSearchField() {
        binding.searchField.visibility = View.GONE

        binding.glassBtn.setOnClickListener {
            if (binding.searchField.visibility === 0) {
                binding.searchField.visibility = View.GONE
            }else{
                binding.searchField.visibility = View.VISIBLE
            }
        }

    }

    private fun initLesson() {
        val lessonAdapter = LessonAdapter(mutableListOf())
        binding.lessonView.adapter = lessonAdapter

        viewModal.loadAllLesson()

        binding.searchField.addTextChangedListener {
            val keyword = it.toString().toUpperCase().trim()
            viewModal.searchValue(keyword)
        }

        viewModal.searchResult.observe(this) {
            list ->
            binding.lessonView.layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            lessonAdapter.updateData(list)
        }

        }


}