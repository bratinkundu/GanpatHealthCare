package com.example.bratinkundu.ganpathealthcare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var btn1 = button2
        var btn2= button3
        btn2.setOnClickListener{
            val intent1= Intent(this,Main3Activity::class.java)
            startActivity(intent1)
        }
        btn1.setOnClickListener({
            val intent3 = Intent(this,Main4Activity::class.java)
            startActivity(intent3)
        })
    }
}
