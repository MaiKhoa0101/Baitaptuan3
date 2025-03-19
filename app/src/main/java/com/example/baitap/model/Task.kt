package com.example.baitap.model

data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task> // Extract tasks from "data"
)
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String
)
