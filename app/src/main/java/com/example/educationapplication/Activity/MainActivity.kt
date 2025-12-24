package com.example.educationapplication.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationapplication.Adapter.LessonAdapter
import com.example.educationapplication.MainViewModal.MainViewModal
import com.example.educationapplication.R
import com.example.educationapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModal= MainViewModal()

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
            binding.searchField.visibility = View.VISIBLE
        }
    }

    private fun initLesson() {
        binding.lessonLoad.visibility = View.VISIBLE

        viewModal.loadLesson().observeForever {
            binding.lessonView.layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            binding.lessonView.adapter = LessonAdapter(it)
        }
    }
}