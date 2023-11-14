package com.example.tugasper11_retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasper11_retrofit.databinding.ActivityMainBinding
import com.example.tugasper11_retrofit.model.Data
import com.example.tugasper11_retrofit.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: List<Data>

    private val client = ApiClient.getInstance()
    private val call = client.getAllNews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        call.enqueue(object : Callback<List<Data>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if(response.isSuccessful) {
                    val newsData = response.body()
                    newsData?.let {
                        newsList = it
                        newsAdapter = NewsAdapter(newsList)
                        recyclerView.adapter = newsAdapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
            }
        })

        with (binding) {
            recyclerView = rvNews
        }
    }
}