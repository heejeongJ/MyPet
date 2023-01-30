package com.example.mypet

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
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

        var myPageGo = findViewById<Button>(R.id.myPageB)
        myPageGo.setOnClickListener{
            var mypageIntent = Intent(this, MyPage::class.java)
            startActivity(mypageIntent)
        }
    }
}