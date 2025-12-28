package com.example.educationapplication.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.educationapplication.MainViewModal.AuthViewModal
import com.example.educationapplication.R
import com.example.educationapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private val viewModal = AuthViewModal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val regisBtn = binding.regisBtn

        binding.RAlertForm.visibility = View.GONE

        regisBtn.setOnClickListener {
            val user = binding.RUsernameTxt.text.toString().trim()
            val email = binding.REmailTxt.text.toString().trim()
            val password = binding.RPasswordTxt.text.toString().trim()

            if (user.isEmpty() || email.isEmpty() || password.isEmpty()){
                binding.RAlertForm.visibility = View.VISIBLE
            } else {
                viewModal.register(user, email, password)
            }

        }

        viewModal.regisResult.observe(this){
            result ->
            result.onSuccess {
                message ->
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            }

            result.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}