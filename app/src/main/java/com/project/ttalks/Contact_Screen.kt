package com.project.ttalks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.project.ttalks.databinding.ActivityContactScreenBinding

class Contact_Screen : AppCompatActivity() {

    private lateinit var binding: ActivityContactScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        super.onCreate(savedInstanceState)
        binding = ActivityContactScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnEmail.setOnClickListener {
            openLink("mailto:talha0750@gmail.com")
        }

        binding.btnLinkedin.setOnClickListener {
            openLink("https://www.linkedin.com/in/muhammad-talha-offofc")
        }

        binding.btnGithub.setOnClickListener {
            openLink("https://github.com/mtalhaofc")
        }

        binding.btnPortfolio.setOnClickListener {
            openLink("https://mtalha.me")
        }

        binding.fabClose.setOnClickListener{
            finish()
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}