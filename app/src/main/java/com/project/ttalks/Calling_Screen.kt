@file:Suppress("UNREACHABLE_CODE")

package com.project.ttalks

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


import com.project.ttalks.databinding.ActivityCallingScreenBinding
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import org.w3c.dom.Text

class Calling_Screen : AppCompatActivity() {
    private lateinit var binding : ActivityCallingScreenBinding
    private lateinit var targetuserid : EditText
    private lateinit var myUserIdText : TextView
    private lateinit var videocallbutton :  ZegoSendCallInvitationButton
    private lateinit var audiocallbutton : ZegoSendCallInvitationButton


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCallingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)


        targetuserid   = binding.targetUserId
        myUserIdText   = binding.myUserIdText
        videocallbutton   = binding.videoCallButton
        audiocallbutton =   binding.audioCallButton

        val myUserId = intent.getStringExtra("myUserId")
        myUserIdText.text = "Hi $myUserId \n Whom do you want to call?"
        targetuserid.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val targetUserID = targetuserid.text.toString()
                if(targetUserID.isNotEmpty()){
                    startVideoCall(targetUserID)
                    startaudiocall(targetUserID)
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.contactUs.setOnClickListener{
            val intent = Intent(this, Contact_Screen::class.java)
            startActivity(intent)
        }

    }
    private fun startVideoCall(targetUserID : String) {
        val targetUserName : String = targetUserID
        videocallbutton.setIsVideoCall(true)
        videocallbutton.resourceID = "zego_uikit_call"
        videocallbutton.setInvitees(listOf(ZegoUIKitUser(targetUserID,targetUserName)))

    }

    private fun startaudiocall(targetUserID : String) {
        val targetUserName : String = targetUserID
        audiocallbutton.setIsVideoCall(false)
        audiocallbutton.resourceID = "zego_uikit_call"
        audiocallbutton.setInvitees(listOf(ZegoUIKitUser(targetUserID,targetUserName)))

    }
}