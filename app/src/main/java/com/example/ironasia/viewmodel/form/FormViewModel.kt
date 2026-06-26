package com.example.ironasia.viewmodel.form

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ironasia.data.repository.DbRepository
import com.example.ironasia.data.repository.model.userResponse.UserItem
import com.example.ironasia.di.FetchDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface FormViewModelType {
    val userState: StateFlow<FetchDataState<Int>?>

    fun addUserData(userData: UserItem)
}

@HiltViewModel
class FormViewModel
@Inject
constructor(
    private val dbRepository: DbRepository
) : ViewModel(), FormViewModelType {
    private val _userState = MutableStateFlow<FetchDataState<Int>?>(null)
    override val userState: StateFlow<FetchDataState<Int>?> = _userState

    override fun addUserData(userData: UserItem) {
        Log.d("FormViewModel", "Add User Data Called with User Data : $userData")

        viewModelScope.launch {
            dbRepository.insertUser(userData)
            Log.d("FormViewModel", "Success Insert User to Local Database")
        }
    }
}