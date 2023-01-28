package com.android.mypet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.mypet.R

class SignUp_sub2 : AppCompatActivity() {
    lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_sub2)
        var next = findViewById<Button>(R.id.signUpNextButton)
        var idInput = findViewById<EditText>(R.id.signUpEditT)

        if (intent.hasExtra("email")){
            email = intent.getStringExtra("email").toString()
            Log.d("email: ", email)
        } else {
            Log.d("no email ", ": please go back")
        }

        next.setOnClickListener{
            val nextIntent = Intent(this, SignUp_sub3::class.java)
            nextIntent.putExtra("id", idInput.text.toString())
            nextIntent.putExtra("email", email)
            setResult(Activity.RESULT_OK, nextIntent)
            finish()
            startActivity(nextIntent)
        }
    }
}