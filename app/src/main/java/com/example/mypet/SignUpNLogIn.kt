package com.example.mypet

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
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
import androidx.appcompat.app.AlertDialog

class SignUpNLogIn : AppCompatActivity() {
    lateinit var sqlDB: SQLiteDatabase
    lateinit var id : String
    lateinit var password : String
    lateinit var dbhelper : dbHelper.myDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_nlog_in)

        var idText = findViewById<EditText>(R.id.logInIdEditText)
        var passwordText = findViewById<EditText>(R.id.logInPassWordEditText)
        var loginB = findViewById<Button>(R.id.loginB)
        var registerB = findViewById<Button>(R.id.signupB)
        registerB.setOnClickListener{
            val nextIntent = Intent(this, SignUp::class.java)
            startActivity(nextIntent)
        }

        loginB.setOnClickListener{
            id = idText.text.toString()
            password = passwordText.text.toString()

            dbhelper = dbHelper().myDBHelper(this)
            var sql = "SELECT * FROM USER WHERE userid=${id}"

            var main_page = Intent(this, MainPage::class.java)
            startActivity(main_page)

//            var login_cursor = dbHelper().selectSql(sql, dbhelper)
//
//            while (login_cursor.moveToNext()){
//                if (login_cursor.getString(1) == null){
//                    val builder = AlertDialog.Builder(this)
//                    builder.setTitle("로그인 실패")
//                        .setMessage("일치하는 회원정보가 없습니다. 회원가입을 진행해주세요.")
//                        .setPositiveButton("Start", DialogInterface.OnClickListener({
////                    메인화면으로 넘기기
//                                dialog, id -> Intent(this, SignUpNLogIn::class.java)
//                        }))
//                    builder.create()
//                    builder.show()
//                } else if (login_cursor.getString(2) == id && login_cursor.getString(3) == password) {
//                    val builder = AlertDialog.Builder(this)
//                    builder.setTitle("로그인 성공")
//                        .setMessage("${login_cursor.getString(1)} 님, 로그인이 완료되었습니다! ")
//                        .setPositiveButton("Start", DialogInterface.OnClickListener({
////                    메인화면으로 넘기기
//                                dialog, id -> Intent(this, SignUpNLogIn::class.java)
//                        }))
//                    builder.create()
//                    builder.show()
//                }
            }





        }


    }

//    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "user.db", null, 1){
//        override fun onCreate(db: SQLiteDatabase?){
//            db!!.execSQL("CREATE TABLE IF NOT EXISTS USER(id Integer PRIMARY KEY AUTOINCREMENT, userID VARCHAR(255), email VARCHAR(255), password VARCHAR(255))")
//        }
//        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion : Int){
//            db!!.execSQL("DROP TABLE IF EXISTS USER")
//            onCreate(db)
//        }
//    }