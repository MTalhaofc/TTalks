package com.project.ttalks

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.ttalks.databinding.ActivityLoginPageBinding
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig


class Login_Page : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var myuserid : EditText
    private lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?){
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

myuserid = binding.myUserId
        btnlogin = binding.btnLoginUser
        btnlogin.setOnClickListener{
            val myUserId = myuserid.text.toString()
            if(myUserId.isNotEmpty()){
                val intent = Intent(this, Calling_Screen::class.java)
                intent.putExtra("myUserId", myUserId)
                startActivity(intent)
                setupZegoUIKit(myUserId)
            }
        }

    }
    private fun setupZegoUIKit(userID : String){
        val application: Application = application
        val appID: Long = 118996816
            val appSign : String = "7825981ec5cc9ddf3e53707267c3dc77b7626ee20b5ac5169328e125ee94dfe7"
        val userName : String = userID
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
        ZegoUIKitPrebuiltCallService.init(application, appID, appSign, userID, userName, callInvitationConfig)
    }
    fun ondestroy(){
        super.onDestroy()
        ZegoUIKitPrebuiltCallService.unInit()
    }
}