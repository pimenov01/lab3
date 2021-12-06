package com.example.lab3

import android.content.Intent
import android.os.Bundle
import com.example.lab3.databinding.ActivityMainBinding
//adb shell dumpsys activity activities | findStr lab3 | findStr Hist
class MainActivity : OptionedActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.secondButton.setOnClickListener { toSecond() }
    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


    private fun toSecondNoTrace() {

    }


}