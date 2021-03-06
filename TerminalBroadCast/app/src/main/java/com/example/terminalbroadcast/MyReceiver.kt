package com.example.terminalbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver(){
    var state:String?=null
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode is Turned ON", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Airplane Mode is Turned OFF", Toast.LENGTH_LONG).show()
        }
    }

}
