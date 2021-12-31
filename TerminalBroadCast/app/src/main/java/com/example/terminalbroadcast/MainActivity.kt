package com.example.terminalbroadcast

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var receiver = MyReceiver()
        var sendBtn = findViewById<Button>(R.id.sendBtn)

        sendBtn.setOnClickListener(){
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.setData(Uri.parse("03135255157"))
            // Add the message (sms) with the key ("sms_body").
            smsIntent.putExtra("sms_body", "Hello this is sms");
            startActivity(smsIntent)
        }


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)

        }
    }
}