package com.example.baitap.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.baitap.api.RetrofitInstance
import com.example.baitap.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private val _isLoading = MutableStateFlow(false)  // ✅ Add loading state
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.apiService.getTasks()
                if (response.isSuccess) { // Check if API call was successful
                    _tasks.value = response.data // Extract task list
                }
            } catch (e: Exception) {
                // Handle API errors (show logs, Toast, etc.)
            } finally {
                _isLoading.value = false
            }
        }
    }

}
