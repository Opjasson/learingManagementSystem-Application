package com.example.educationapplication.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.educationapplication.MainViewModal.AuthViewModal
import com.example.educationapplication.MainViewModal.MainViewModal
import com.example.educationapplication.R
import com.example.educationapplication.Repository.MainRepository
import com.example.educationapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModal = AuthViewModal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.LAlertForm.visibility = View.GONE

//        Navigate register page
        binding.LGotoRegis.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


//        Handle login button
        binding.loginBtn.setOnClickListener {
            var email = binding.emailTxt.text.toString().trim()
            var password = binding.passwordTxt.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()){
                binding.LAlertForm.visibility = View.VISIBLE
            }else{
                viewModal.login(email, password)
            }

        }

        viewModal.loginResult.observe(this) {
            result ->
            result.onSuccess {
                message ->
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }

            result.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }

    }
}