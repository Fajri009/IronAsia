package com.example.ironasia.viewmodel.contact.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ironasia.data.repository.DbRepository
import com.example.ironasia.data.repository.model.userResponse.UserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface DetailContactViewModelType {
    val userData: StateFlow<UserItem?>

    fun getUserById(id: String)
    fun deleteUser(id: String)
}

@HiltViewModel
class DetailContactViewModel
@Inject
constructor(
    private val dbRepository: DbRepository
) : ViewModel(), DetailContactViewModelType {
    private val _userData = MutableStateFlow<UserItem?>(null)
    override val userData: StateFlow<UserItem?> = _userData

    override fun getUserById(id: String) {
        viewModelScope.launch {
            dbRepository.getUserById(id).collect {
                _userData.value = it
            }
        }
    }

    override fun deleteUser(id: String) {
        viewModelScope.launch {
            dbRepository.deleteUser(id)
        }
    }
}