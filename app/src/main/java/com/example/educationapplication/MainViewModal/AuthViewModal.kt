package com.example.educationapplication.MainViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapplication.Repository.AuthRepository

class AuthViewModal: ViewModel() {
    private val repository = AuthRepository()

//    Login handle result
    private val _loginResult = MutableLiveData<Result<String>>() // state management yang datanya bisa dirubah
    val loginResult: LiveData<Result<String>> = _loginResult // state management yang datanya hanya bisa dibaca/dilihat

    fun login(email: String, password: String) {
        repository.loginAuth(email, password) {
            success, message ->
            if (success) {
                _loginResult.value = Result.success("Login barhasil")

            }else {
                _loginResult.value = Result.failure(Exception(message))
            }
        }
    }

//    Register handle result

    private val _regisResult = MutableLiveData<Result<String>>()
    val regisResult: LiveData<Result<String>> = _regisResult

    fun register(user: String, email: String, password: String){
        repository.registerAuth(user, email, password) {
            success, message ->
            if (success) {
                _regisResult.value = Result.success("Register berhasil")
            }else {
                _regisResult.value = Result.failure(Exception(message))
            }
        }
    }
}