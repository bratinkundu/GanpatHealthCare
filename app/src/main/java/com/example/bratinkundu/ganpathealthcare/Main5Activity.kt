package com.example.bratinkundu.ganpathealthcare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main5.*
import java.text.SimpleDateFormat
import java.util.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val date = editText9
        val cdate = SimpleDateFormat("dd-MMM-yyyy")
        val today= Date()
        val fdate=cdate.format(today)
        date.setText(fdate.toString())
        var helper = DataBaseHandler(this)
        val upbtn =button4
        val id = editText2
        val name = editText4
        val addr = editText5
        val desc = editText7
        var intent7 : Intent = intent
        val uid = intent7.getStringExtra("id")
        val uname= intent7.getStringExtra("name")
        name.setText(uname.toString())
        id.setText(uid.toString())
        upbtn.setOnClickListener({
            if(id.text.toString()=="")
            {
                Toast.makeText(this,"ID cannot be blank",Toast.LENGTH_LONG).show()
            }
            else {
                val patient1 = Patients(id.text.toString().toInt(), date.text.toString(), name.text.toString(), addr.text.toString(), desc.text.toString())
                helper.updateData(patient1)
                Toast.makeText(this, "Updated Successfuly", Toast.LENGTH_SHORT).show()
                id.setText("")
                date.setText("")
                name.setText("")
                addr.setText("")
                desc.setText("")
            }
            })


    }
}
