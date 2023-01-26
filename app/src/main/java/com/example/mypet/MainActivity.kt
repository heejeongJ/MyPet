package com.example.mypet

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

//login 관련 선언
    lateinit var inputIdButton : EditText
    lateinit var inputUserId : String
    lateinit var inputPasswordButton : EditText
    lateinit var inputPassword : String

//DB 관련 선언
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    fun inertDB(){

    }
    fun clickLoginBtn(){
//    kotlin.UninitializedPropertyAccessException: lateinit property myHelper has not been initialized 에러 발생
        myHelper = myDBHelper(this)
        val loginButton = findViewById<Button>(R.id.loginButton)
        var loginCompleted = findViewById<TextView>(R.id.loginCompleted)
        inputIdButton = findViewById(R.id.inputID)
        inputPasswordButton = findViewById(R.id.inputPasswd)

        loginButton.setOnClickListener{
            Log.d("hi", "hi")
            inputUserId = inputIdButton.text.toString()
            inputPassword = inputPasswordButton.text.toString()
            Log.d("id", inputUserId)
            Log.d("password", inputPassword)

            sqlDB = myHelper.readableDatabase
            var cursor: Cursor

//            cursor = sqlDB.rawQuery("SELECT email FROM USER WHERE email='" + inputUserId + "'", null)

            cursor = sqlDB.rawQuery("SELECT * FROM USER", null)
            while (cursor.moveToNext()){
                if (cursor.getString(1) == null){
                    Log.d("dd", "no")
                }

            }
//            var id = cursor.getString(1)
//            var email = cursor.getString(2)
//            Log.d("id", id)
//
//            loginCompleted.setText(email)
            sqlDB.close()
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickLoginBtn()

    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1){
        override fun onCreate(db: SQLiteDatabase?){
            db!!.execSQL("CREATE TABLE USER(id Integer PRIMARY KEY AUTOINCREMENT, userID VARCHAR(255), email VARCHAR(255), password VARCHAR(255))")
        }
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion : Int){
            db!!.execSQL("DROP TABLE IF EXISTS USER")
            onCreate(db)
        }
    }
}