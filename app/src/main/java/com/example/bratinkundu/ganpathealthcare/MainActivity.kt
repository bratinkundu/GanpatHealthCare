package com.example.bratinkundu.ganpathealthcare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var usname=editText
        var passwd=editText3
        var btn=button
        btn.setOnClickListener {
            val user_name =usname.text.toString()
            val password = passwd.text.toString()
            if (user_name=="usser" && password=="mypassword")
            {
                val intent = Intent(this,Main2Activity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Invalid Username or Password", Toast.LENGTH_LONG).show()
            }
        }
    }
}
