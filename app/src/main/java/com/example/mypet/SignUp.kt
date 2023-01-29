package com.example.mypet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var check = findViewById<Button>(R.id.signUpButton2)
        check.setOnClickListener{

            val nextIntent = Intent(this, SignUp_sub1::class.java)
            startActivity(nextIntent)
        }
    }
}