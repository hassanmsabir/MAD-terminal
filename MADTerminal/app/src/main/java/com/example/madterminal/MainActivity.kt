package com.example.madterminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.madterminal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text = "Hassan Muhammad Sabir Lab Terminal"

        val textView = findViewById<TextView>(R.id.viewData)

        val queue = Volley.newRequestQueue(this)
        val url = "https://run.mocky.io/v3/512910a3-96f8-41c1-b339-3d6b00c01f04"

        val stringRequest = StringRequest(
            Request.Method.GET, url, Response.Listener<String> { response ->
                textView.text = "Response is: ${response.substring(0, 500)}" },
            Response.ErrorListener { textView.text = "That didn't work!" })

        queue.add(stringRequest)

    }
}