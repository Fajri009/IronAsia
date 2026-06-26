package com.example.ironasia.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ironasia.data.datastore.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface LoginViewModelType {
    fun loginSuccess()
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val sessionManager: SessionManager
): ViewModel(), LoginViewModelType {
    override fun loginSuccess() {
        viewModelScope.launch {
            sessionManager.saveLogin()
        }
    }
}