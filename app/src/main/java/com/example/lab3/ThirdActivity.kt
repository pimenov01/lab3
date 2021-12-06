package com.example.lab3

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import com.example.lab3.databinding.ThirdActivityBinding

class ThirdActivity : OptionedActivity() {

    private lateinit var binding : ThirdActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstButton.setOnClickListener { toFirst() }
        binding.secondButton.setOnClickListener { toSecond() }
    }

    private fun toFirst() {
        //with startActivityForResult() method
        /*this.setResult(RESULT_OK)
        finish()*/
        //without that method
        val intent = Intent(this, MainActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun toSecond() {
        finish()
    }

}