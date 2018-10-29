package com.example.bratinkundu.ganpathealthcare

import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by BRATIN KUNDU on 07-04-2018.
 */
val Database_name="NewDB2"
val Table_name="Patient_r"
val ColId="ID"
val ColDate="Date"
val ColName="Name"
val ColAdd="Address"
val ColDes="Description"
class DataBaseHandler(var context : Context): SQLiteOpenHelper(context, Database_name,null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table "+ Table_name +" ("+ ColId +" INTEGER Primary Key, "+ ColDate+" date, "+ ColName +" varchar2(30), "+ ColAdd +" varchar2(30), "+ ColDes +" varchar2(30));"
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXIST"+ Table_name)
    }
    fun insertData(patients: Patients)
    {
        val db = this.writableDatabase
        val contentvalues= ContentValues()
        contentvalues.put(ColId,patients.id)
        contentvalues.put(ColDate,patients.date)
        contentvalues.put(ColName,patients.name)
        contentvalues.put(ColAdd,patients.address)
        contentvalues.put(ColDes,patients.description)
        val result=db.insert(Table_name,null,contentvalues)
        if(result == (-1.toLong()))
        {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }
    }
    fun readData(name:String):MutableList<Patients>
    {
        var list:MutableList<Patients> = ArrayList()
        val db = this.readableDatabase
        val query = "select * from "+ Table_name+" where "+ ColName +" like '"+name+"%';"
        val result =db.rawQuery(query,null)
        if(result.moveToFirst())
        {
            do {
                var p = Patients()
                p.id =result.getString(result.getColumnIndex(ColId)).toInt()
                p.date=result.getString(result.getColumnIndex(ColDate))
                p.name=result.getString(result.getColumnIndex(ColName))
                p.description=result.getString(result.getColumnIndex(ColDes))
                p.address=result.getString(result.getColumnIndex(ColAdd))
                list.add(p)
            }
            while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun updateData (patients: Patients)
    {
        val db = this.writableDatabase
        val contentvalues= ContentValues()
        contentvalues.put(ColId,patients.id)
        contentvalues.put(ColDate,patients.date)
        contentvalues.put(ColName,patients.name)
        contentvalues.put(ColAdd,patients.address)
        contentvalues.put(ColDes,patients.description)
        db.update(Table_name,contentvalues, ColId+"=?", arrayOf(patients.id.toString()))
    }
    fun counttables(): Long {
        val db = this.readableDatabase
        val rowcount= DatabaseUtils.queryNumEntries(db, Table_name)
        return rowcount

    }
}

