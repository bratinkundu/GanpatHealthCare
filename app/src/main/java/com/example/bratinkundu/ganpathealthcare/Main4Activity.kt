package com.example.bratinkundu.ganpathealthcare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main4.*


class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val myid = Array<String>(10){""}
        val myname = Array<String>(10){""}
        var db = DataBaseHandler(context = this)
        val showbtn =button5
        val name= editText6
        val list = mylist
        val lists= ArrayList<String>()
        lists.clear()
        showbtn.setOnClickListener({
            lists.clear()
            if(name.text.toString()=="")
            {
                      lists.clear()
            }
            else
            {
                var data = db.readData(name.text.toString())
                for (i in 0..(data.size - 1))
                {
                    myid[i]=data.get(i).id.toString()
                    myname[i]=data.get(i).name
                    lists.add("\n\nID:- " + data.get(i).id.toString() + "\n" + "Date:- " + data.get(i).date + "\n" + "Name:- " + data.get(i).name + "\n" + "Address:- " + data.get(i).address + "\n" + "Description:- " + data.get(i).description + "\n\n")
                    val listadapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,lists)
                    list.adapter = listadapter
                }
                name.setText("")
            }
            })
        list.setOnItemClickListener{
            parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            val intent6 = Intent(this,Main5Activity::class.java)
            intent6.putExtra("id",myid[position])
            intent6.putExtra("name",myname[position])
            startActivity(intent6)
            list.adapter=null
        }
    }
}
