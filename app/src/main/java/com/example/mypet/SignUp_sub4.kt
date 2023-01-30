package com.example.mypet

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignUp_sub4 : AppCompatActivity() {
    lateinit var email : String
    lateinit var id : String
    lateinit var password: String
    lateinit var name : String
    lateinit var dbhelper : dbHelper.myDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_sub4)

        var next = findViewById<Button>(R.id.signUpNextButton)
        var nameInput = findViewById<EditText>(R.id.signUpNT)

        if (intent.hasExtra("password")){
            id = intent.getStringExtra("id").toString()
            email = intent.getStringExtra("email").toString()
            password = intent.getStringExtra("password").toString()
            Log.d("email", email)
            Log.d("id", id)
            Log.d("password", password)
            Log.d("nameInput", nameInput.text.toString())
        } else {
            Log.d("no email ", ": please go back")
        }

        next.setOnClickListener{
            dbhelper = dbHelper().myDBHelper(this)
            var sql = "INSERT INTO user(email, userId, password, name) VALUES ('${email}', '${id}', '${password}', '${nameInput.text.toString()}')"
            dbHelper().insertSql(sql, dbhelper)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("회원가입 완료")
                .setMessage("${email} 님, 회원가입이 완료되었습니다! ")
                .setPositiveButton("Start", DialogInterface.OnClickListener({
//                    메인화면으로 넘기기
                    dialog, id -> Intent(this, MainPage::class.java)
                }))
            builder.create()
            builder.show()
        }
    }
}