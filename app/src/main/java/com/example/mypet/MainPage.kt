package com.example.mypet

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainPage: AppCompatActivity() {

    lateinit var puppyImg2:ImageView
    lateinit var todayChkButton: Button
    lateinit var hospitalButton: Button
    lateinit var healthButton: Button
    lateinit var mainButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.main_page)

        todayChkButton = findViewById<Button>(R.id.todayChkButton)
        hospitalButton = findViewById<Button>(R.id.hospitalButton)
        healthButton = findViewById<Button>(R.id.healthButton)
        mainButton = findViewById<Button>(R.id.mainButton)

        todayChkButton.setOnClickListener{
            //캘린더페이지로
           // var intent=Intent(this,::class.java)
            //startActivity(intent)
        }
        hospitalButton.setOnClickListener{
            //병원정보페이지로
            //var intent=Intent(this,::class.java)
            //startActivity(intent)
        }
        healthButton.setOnClickListener{
            //건강정보페이지로
            //var intent=Intent(this,::class.java)
            //startActivity(intent)
        }
        mainButton.setOnClickListener{
            //메인페이지로
            //var intent= Intent(this,::class.java)
            //startActivity(intent)
        }

    }
}

