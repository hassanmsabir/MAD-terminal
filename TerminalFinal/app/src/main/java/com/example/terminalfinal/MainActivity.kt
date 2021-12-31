package com.example.terminalfinal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.services.MyService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_servic.*
import kotlinx.android.synthetic.main.new_layout.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    var edi :String = "03334511804"
    var edi2:String="This is the Body"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Intent(this, MyService::class.java).also {
            startService(it)
            Toast.makeText(this,"Services is running ", Toast.LENGTH_LONG).show()
        }


        reccyle.layoutManager= LinearLayoutManager(this)
        reccyle.adapter= customadapter()
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.RECEIVE_SMS) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.RECEIVE_SMS,android.Manifest.permission.SEND_SMS),
                111
            )
        }
        else{
            reciveMsg()
        }
        binding.btn2.setOnClickListener{
            var sms = SmsManager.getDefault()
            sms.sendTextMessage(edi,"ME",edi2,null,null)
        }
        binding.btnser.setOnClickListener{
            val intent = Intent(this,servic::class.java)
            startActivity(intent)
        }


    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            reciveMsg()
        }
    }

    private fun reciveMsg() {
        val br = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    for (sms in Telephony.Sms.Intents.getMessagesFromIntent(intent)){
                        Toast.makeText(applicationContext,sms.displayMessageBody,Toast.LENGTH_LONG).show()

                    }
                }
            }

        }
        registerReceiver(br, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }
}