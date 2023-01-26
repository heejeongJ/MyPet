package com.example.mypet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var go = findViewById<Button>(R.id.button5)
        go.setOnClickListener{
            val nextIntent = Intent(this, SignUpNLogIn::class.java)
            startActivity(nextIntent)
        }
    }
}