package com.example.mypet

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    inner class myDBHelper(context: Context): SQLiteOpenHelper(context, "user", null, 1 ){
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE groupTBL (id CHAR(20), email CHAR(20), userid INTEGER, password INTEGER, name CHAR(20));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)
        }
    }
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var go = findViewById<Button>(R.id.button5)
        go.setOnClickListener{
            val nextIntent = Intent(this, SignUpNLogIn::class.java)
            startActivity(nextIntent)
        }

        var goToPetRegistration = findViewById<Button>(R.id.button6)
        goToPetRegistration.setOnClickListener{
            val nextIntent = Intent(this, PetRegistration::class.java)
            startActivity(nextIntent)
        }
    }
}