package com.example.baitap.api

import com.example.baitap.model.DetailTaskResponse
import com.example.baitap.model.Task
import com.example.baitap.model.TaskResponse
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

// Define the API service
interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): TaskResponse // Expect full API response
    @GET("{id}")
    suspend fun getDetailTasks(@Path("id") id: Int): DetailTaskResponse

}

// Create a singleton object for Retrofit initialization
object RetrofitInstance {
    val apiTask1: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://amock.io/api/researchUTH/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    val apiDetail1: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://amock.io/api/researchUTH/task/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
