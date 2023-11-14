package com.example.tugasper11_retrofit.retrofit

import com.example.tugasper11_retrofit.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/tech/news")
    fun getAllNews(): Call<List<Data>>
}