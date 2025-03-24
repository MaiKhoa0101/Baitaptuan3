package com.example.baitap.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.baitap.api.RetrofitInstance
import com.example.baitap.model.Attachment
import com.example.baitap.model.Reminder
import com.example.baitap.model.Subtask
import com.example.baitap.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private val _taskDetail = MutableStateFlow<Task?>(null)
    val taskDetail: StateFlow<Task?> = _taskDetail

//    // Subtask details
//    private val _subtaskDetails = MutableStateFlow<List<Subtask>>(emptyList())
//    val subtaskDetails: StateFlow<List<Subtask>> = _subtaskDetails
//
//    // Attachments
//    private val _attachmentsDetails = MutableStateFlow<List<Attachment>>(emptyList())
//    val attachmentsDetails: StateFlow<List<Attachment>> = _attachmentsDetails
//
//    // Reminders
//    private val _reminderDetails = MutableStateFlow<List<Reminder>>(emptyList())
//    val reminderDetails: StateFlow<List<Reminder>> = _reminderDetails

    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.apiTask1.getTasks()
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

    fun getDetailTasks(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.apiDetail1.getDetailTasks(id)
                if (response.isSuccess) {
                    _taskDetail.value = response.data // Extract single Task from response
                } else {
                    println("Failed to fetch task details: ${response.message}")
                }
            } catch (e: Exception) {
                println("Error: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}


