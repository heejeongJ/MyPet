package com.example.mypet
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.mypet.SignUp_sub2

class SignUp_sub1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_sub1)


        var next = findViewById<Button>(R.id.signUpNextButton)
        var emailInput = findViewById<EditText>(R.id.signUpEditT)

        next.setOnClickListener{
            val nextIntent = Intent(this, SignUp_sub2::class.java)
            nextIntent.putExtra("email", emailInput.text.toString())
            setResult(Activity.RESULT_OK, nextIntent)
            finish()
            startActivity(nextIntent)
        }
    }
}