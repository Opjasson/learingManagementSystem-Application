package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Repository.AuthRepository

class AuthViewModal: ViewModel() {
    private val repository = AuthRepository()

    private val _loginResult = MutableLiveData<Result<String>>() // state management yang datanya bisa dirubah
    val loginResult: LiveData<Result<String>> = _loginResult // state management yang datanya hanya bisa dibaca/dilihat

    fun login(email: String, password: String) {
        repository.loginAuth(email, password) {
            success, message ->
            if (success) {
                _loginResult.value = Result.success("Login berhasil")

            }else {
                _loginResult.value = Result.failure(Exception(message))
            }
        }
    }
}