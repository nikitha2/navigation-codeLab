package com.example.android.codelabs.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.codelabs.navigation.databinding.ActivityMainBinding
import com.example.android.codelabs.navigation.databinding.NavigationActivityBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val userId: String

        if(extras?.containsKey("userId") == true){
            userId = extras.getString("userId", "0")
        }

    }

}