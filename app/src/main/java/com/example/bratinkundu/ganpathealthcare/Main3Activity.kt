package com.example.bratinkundu.ganpathealthcare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*
import java.text.SimpleDateFormat
import java.util.*


class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val helper = DataBaseHandler(this)
        val date=editText9
        val cdate = SimpleDateFormat("dd-MMM-yyyy")
        val today= Date()
        val fdate=cdate.format(today)
        date.setText(fdate.toString())
        val btn3 = button4
        val id = editText2
        val name = editText4
        val addr = editText5
        val desc = editText7

        btn3.setOnClickListener {
            if(id.text.toString()=="")
            {
                Toast.makeText(this,"ID cannot be blank",Toast.LENGTH_LONG).show()
            }
            else
            {
                val patient = Patients(id.text.toString().toInt(),date.text.toString(), name.text.toString(), addr.text.toString(), desc.text.toString())
                helper.insertData(patient)
                name.setText("")
                addr.setText("")
                desc.setText("")
                val cdate = SimpleDateFormat("dd-MMM-yyyy")
                val today= Date()
                val fdate=cdate.format(today)
                date.setText(fdate.toString())
            }
        }
    }
}
