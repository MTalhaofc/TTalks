package com.project.ttalks

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.ttalks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)


        Handler().postDelayed({
            val intent = Intent(this, Login_Page::class.java)
            startActivity(intent)
            finish()
        }, 500)
    }

    }
