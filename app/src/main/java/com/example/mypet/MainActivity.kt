package com.example.mypet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mypet.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var go = findViewById<Button>(R.id.button5)
        go.setOnClickListener{
            val nextIntent = Intent(this, SignUpNLogIn::class.java)
            startActivity(nextIntent)
        }

//        var goToPetRegistration = findViewById<Button>(R.id.button6)
//        goToPetRegistration.setOnClickListener{
//            val nextIntent = Intent(this, PetRegistration::class.java)
//            startActivity(nextIntent)
//        }

        var myhpage = findViewById<Button>(R.id.myPageB)
        myhpage.setOnClickListener{
            val nextIntent = Intent(this, MyPage::class.java)
            startActivity(nextIntent)
        }
    }
}