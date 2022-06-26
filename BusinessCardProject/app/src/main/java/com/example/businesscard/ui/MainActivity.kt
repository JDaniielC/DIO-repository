package com.example.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Toda activity deve ser feito o binding:
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}