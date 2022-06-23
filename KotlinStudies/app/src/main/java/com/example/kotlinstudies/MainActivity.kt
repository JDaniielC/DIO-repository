package com.example.kotlinstudies

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlinstudies.data.MatchesApi
import com.example.kotlinstudies.databinding.ActivityMainBinding
import com.example.kotlinstudies.domain.Match
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var matchesApi: MatchesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Utilizando Android Jetpack
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        setupHttpClient()
        setupMatchesList()

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun setupHttpClient() {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://digitalinnovationone.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        matchesApi = retrofit.create(MatchesApi::class.java)
    }

    private fun setupMatchesList() {
        matchesApi.getMatches().enqueue(
            object : Callback<List<Match>> {
                override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                    if (response.isSuccessful()) {
                        var matches: List<Match>? = response.body();
                        Log.i("Simulando", "Deu tudo certo: " + matches?.size);
                    } else {
                        Log.v("Retrofit", "No response");
                    }
                }

                override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                    Log.v("RetrofitError", "Error in Call")
                }
            },
        )
    }
}