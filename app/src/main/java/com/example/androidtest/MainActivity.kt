package com.example.androidtest

import android.os.Bundle
import android.util.ArrayMap
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sa = SparseArray<Int>()
        val am = ArrayMap<Int, Int>()

        sa.put(10, 10);
        val rv = RecyclerView(this);
          val retrofit = Retrofit.Builder()
             .baseUrl("https://api.example.com/")
              .addConverterFactory(GsonConverterFactory.create())
             .build();
        val service: GitHubService = retrofit.create(GitHubService::class.java)
        val repos: Call<List<Repo>> = service.listRepos("octocat")
    }
}