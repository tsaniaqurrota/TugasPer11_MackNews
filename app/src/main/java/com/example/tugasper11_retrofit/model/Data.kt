package com.example.tugasper11_retrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("title")
    val title: String,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("desc")
    val desc: String,
    )