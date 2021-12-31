package com.example.terminalfinal
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.services.MyService
import kotlinx.android.synthetic.main.activity_servic.*

class servic : AppCompatActivity() {
    private lateinit var binding: ActivityServicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnst.setOnClickListener{
            Intent(this,MyService::class.java).also {
                startService(it)

                Log.d(TAG,"Service Running")
            }
        }
        binding.btnstop.setOnClickListener{
            Intent(this,MyService::class.java).also {
                stopService(it)

                Log.d(TAG,"Service Stopped")
            }
        }

    }
}