package com.android.mypet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.mypet.R

class SignUp_sub3 : AppCompatActivity() {
    lateinit var email : String
    lateinit var id : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_sub3)

        var next = findViewById<Button>(R.id.signUpNextButton)
        var passwordInput = findViewById<EditText>(R.id.signUpEditT)

        if (intent.hasExtra("id")){
            id = intent.getStringExtra("id").toString()
            email = intent.getStringExtra("email").toString()
            Log.d("email: ", email)
        } else {
            Log.d("no email ", ": please go back")
        }
        next.setOnClickListener{
            val nextIntent = Intent(this, SignUp_sub4::class.java)
            nextIntent.putExtra("id", id)
            nextIntent.putExtra("email", email)
            nextIntent.putExtra("password", passwordInput.text.toString())
            startActivity(nextIntent)
        }
    }
}