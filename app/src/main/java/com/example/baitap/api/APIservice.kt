package com.example.baitap.api

import com.example.baitap.model.Task
import com.example.baitap.model.TaskResponse
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Define the API service
interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): TaskResponse // Expect full API response
}

// Create a singleton object for Retrofit initialization
object RetrofitInstance {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://amock.io/api/researchUTH/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
