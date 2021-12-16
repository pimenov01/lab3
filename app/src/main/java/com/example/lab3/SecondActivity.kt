package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.databinding.SecondActivityBinding

class SecondActivity : OptionedActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstButton.setOnClickListener { toFirst() }
        binding.thirdButton.setOnClickListener { toThird() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_CODE && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }


    private fun toFirst() {
        finish()
    }

    private fun toThird() {
        //with startActivityForResult() method
        startActivityForResult(Intent(this, ThirdActivity::class.java), RESULT_CODE)
        //without that method
        //startActivity(Intent(this, ThirdActivity::class.java))

    }

    companion object {
        const val RESULT_CODE = 0
    }

}