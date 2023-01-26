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
import android.widget.ImageButton
import android.widget.ImageView

class SignUpNLogIn : AppCompatActivity() {

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase
    lateinit var id : String
    lateinit var password : String

    fun initDB(){
        myHelper = myDBHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_nlog_in)

        var idText = findViewById<EditText>(R.id.logInIdEditText)
        var passwordText = findViewById<EditText>(R.id.logInPassWordEditText)
        var loginB = findViewById<Button>(R.id.loginB)

        initDB()

        loginB.setOnClickListener{
            id = idText.text.toString()
            password = passwordText.text.toString()

            sqlDB = myHelper.readableDatabase
            var cursor: Cursor

            cursor = sqlDB.rawQuery("SELECT * FROM USER WHERE userid=${id}", null)
            while(cursor.moveToNext()){
                if (cursor.getString(1) == null) {
                    Log.d("id", "no id")
                } else {
                    if (cursor.getString(3) == password) {
                        Log.d("id", cursor.getString(1))
                        Log.d("notify", "로그인이 정상적으로 되었습니다")
                    } else {
                        Log.d("notify: ", "비밀번호를 확인해주세요")
                    }
                }
            }

        }


    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "user.db", null, 1){
        override fun onCreate(db: SQLiteDatabase?){
            db!!.execSQL("CREATE TABLE IF NOT EXISTS USER(id Integer PRIMARY KEY AUTOINCREMENT, userID VARCHAR(255), email VARCHAR(255), password VARCHAR(255))")
        }
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion : Int){
            db!!.execSQL("DROP TABLE IF EXISTS USER")
            onCreate(db)
        }
    }
}