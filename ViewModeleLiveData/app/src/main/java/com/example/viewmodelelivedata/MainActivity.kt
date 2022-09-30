package com.example.viewmodelelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewMode: MainViewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewMode = ViewModelProvider(this).get(MainViewMode::class.java)

        mainViewMode.cont.observe(this){
            binding.textResultado.text = it.toString()
        }


        binding.buttonClique.setOnClickListener {
                mainViewMode.addNum()

        }

    }
}