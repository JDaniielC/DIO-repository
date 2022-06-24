package com.example.kotlinstudies.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinstudies.data.MatchesApi
import com.example.kotlinstudies.databinding.ActivityMainBinding
import com.example.kotlinstudies.domain.Match
import com.example.kotlinstudies.ui.adapter.MatchesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var matchesApi: MatchesApi

    // Chamando o adapter
    private var matchesAdapter = MatchesAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        // super do Java:
        super.onCreate(savedInstanceState)
        // Utilizando Android Jetpack
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupHttpClient()
        setupMatchesList()
        setupMatchesRefresh()
        setupFloatingActionButton()
    }

    private fun setupHttpClient() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://digitalinnovationone.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        matchesApi = retrofit.create(MatchesApi::class.java)
    }

    private fun setupMatchesList() {
        // Quando se trata de recyclerView set um tamanho fixo (performance)
        binding.recyclerViewMatches.setHasFixedSize(true)
        binding.recyclerViewMatches.layoutManager = LinearLayoutManager(this)

        findMatchesFromApi()
    }

    private fun setupMatchesRefresh() {
        binding.srlMatchesUpdate.setOnRefreshListener { this::findMatchesFromApi }
    }

    private fun setupFloatingActionButton() {
        binding.fabMain.setOnClickListener{view: View ->
        view.animate().rotationBy(360f).setDuration(500)
            .setListener(object  : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator) {
                    val random = Random()
                    for (i in 0 until matchesAdapter.itemCount) {
                        val match: Match = matchesAdapter.getMatch(i)
                        match.homeTeam.score = random.nextInt(match.homeTeam.stars + 1)
                        match.awayTeam.score = random.nextInt(match.awayTeam.stars + 1)
                        matchesAdapter.notifyItemChanged(i)
                    }
                }
            })
        }
    }

    private fun findMatchesFromApi() {
        // Refreashing:
        binding.srlMatchesUpdate.isRefreshing = true

        matchesApi.getMatches().enqueue(
            object : Callback<List<Match>> {
                override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                    if (response.isSuccessful) {
                        val matches: List<Match> = response.body()!!
                        matchesAdapter = MatchesAdapter(matches)
                        binding.recyclerViewMatches.adapter = matchesAdapter
                    } else {
                        Log.v("Retrofit", "No response")
                    }
                    binding.srlMatchesUpdate.isRefreshing = false
                }

                override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                    Log.v("RetrofitError", "Error in Call")
                    binding.srlMatchesUpdate.isRefreshing = false
                }
            },
        )
    }
}