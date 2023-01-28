package com.example.mypet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Information: AppCompatActivity()  {

     lateinit var vectorImg:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information)
        vectorImg = findViewById(R.id.vectorButton)

        vectorImg.setOnClickListener{
            //반려동물 등록화면으로
            //var intent= Intent(this,:class.java)
            //startActivity(intent)
        }

      }
    }