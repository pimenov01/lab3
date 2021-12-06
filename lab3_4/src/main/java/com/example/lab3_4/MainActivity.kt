package com.example.lab3_4

import android.content.Intent
import android.os.Bundle
import com.example.lab3_4.databinding.ActivityMainBinding
//adb shell dumpsys activity activities | findStr lab3_4 | findStr Hist
class MainActivity : OptionedActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.secondButton.setOnClickListener { toSecond() }
        binding.secondButtonSafe.setOnClickListener { toSecondSafely() }
    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


    private fun toSecondSafely() {
        startActivity(Intent(this, SecondActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
    }


}