package com.example.mypet

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class PetRegistration : AppCompatActivity() {

    lateinit var dbManager : DBManager
    lateinit var sqlitedb : SQLiteDatabase

    lateinit var plusProfile : ImageView
    lateinit var plusB : ImageView

    lateinit var dogButton : Button
    lateinit var catButton: Button
    lateinit var nameET : EditText

    lateinit var birthET : EditText
    lateinit var startedET : EditText
    lateinit var weightET :EditText
    lateinit var diseaseET : EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_registration)

        plusProfile = findViewById(R.id.plusProfile)
        plusB = findViewById(R.id.plusB)
        dogButton = findViewById(R.id.dogButton)
        catButton = findViewById(R.id.catButton)
        nameET = findViewById(R.id.nameET)
        birthET = findViewById(R.id.birthET)
        startedET = findViewById(R.id.birthET)
        weightET = findViewById(R.id.weightET)
        diseaseET = findViewById(R.id.diseaseET)
        saveButton = findViewById(R.id.saveButton)


        // DBManager 객체 받음
        dbManager = DBManager(this, "petinfo", null, 1)

        var pKinds : String = ""
        dogButton.setOnClickListener {
            pKinds = dogButton.text.toString()
            dogButton.setTextColor(Color.DKGRAY)
        }
        catButton.setOnClickListener {
            pKinds = catButton.text.toString()
            catButton.setTextColor(Color.DKGRAY)
        }

        saveButton.setOnClickListener {



            var pName : String = nameET.text.toString()
            var pBirth : String = birthET.text.toString()
            var pStarted : String = startedET.text.toString()
            var pWeight : String = weightET.text.toString()
            var pDisease : String = diseaseET.text.toString()

            sqlitedb = dbManager.writableDatabase

            sqlitedb.execSQL("INSERT INTO petinfo VALUES ('" + pKinds+ "', '" + pName+ "', '"+ pBirth+ "', '" + pStarted+
                "', '"+pWeight+"', '"+ pDisease+"')")
            sqlitedb.close()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("intent_name", pName)
            startActivity(intent)
        }
    }
}