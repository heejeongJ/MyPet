package com.example.mypet

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.mypet.SignUpNLogIn

class MyPage : AppCompatActivity(){
    lateinit var dbhelper : dbHelper.myDBHelper
    lateinit var sql : String
    lateinit var petName : String
    lateinit var petBirth : String
    lateinit var petWithDate: String
    lateinit var petWeight : String
    lateinit var plusBath : TextView
    lateinit var plusCut : TextView
    lateinit var plusHairCut : TextView

    fun onClickEvent(){
        plusBath = findViewById(R.id.imageButton)
        plusCut = findViewById(R.id.cut)
        plusHairCut = findViewById(R.id.imageButton3)

        plusBath.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("작성하기")
                .setMessage("작업중  ")
                .setPositiveButton("Start", DialogInterface.OnClickListener({
                    //                    메인화면으로 넘기기
                        dialog, id -> Intent(this, SignUpNLogIn::class.java)
                }))
            builder.create()
            builder.show()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage)
//        cutdata - petinfo id 이름 바뀜 ㅡㅡ
        var petinfo = findViewById<TextView>(R.id.cutData)

        dbhelper = dbHelper().myDBHelper(this)
//        petId 가져오기 - login session 통해서 petid 가져오기
        sql = "SELECT * FROM petInfo WHERE petId = 1"
        var cursur = dbHelper().selectSql(sql, dbhelper)

        while (cursur.moveToNext()){
            petName = cursur.getString(1)
            petBirth = cursur.getString(2)
            petWithDate = cursur.getString(3)
            petWeight = cursur.getString(5)
        }

        if (petName == null){
            petinfo.setText("아직 반려동물 등록이 완료되지 않았습니다! ")
        } else {
            var inputPetInfo = "이름: ${petName} \n생일: ${petBirth} \n함께 한 날:${petWithDate} \n무게: ${petWeight}"
            petinfo.setText(inputPetInfo)
        }











    }
}