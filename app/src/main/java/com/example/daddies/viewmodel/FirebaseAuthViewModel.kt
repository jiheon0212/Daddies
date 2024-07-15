package com.example.daddies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daddies.repository.FirebaseRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class FirebaseAuthViewModel: ViewModel() {
    private val firebaseRepository = FirebaseRepository()

    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> get() = _user

    fun anonymousLogin() {
        viewModelScope.launch {
            val user = firebaseRepository.anonymousLogin()
            _user.value = user
        }
    }
}