package com.example.bratinkundu.ganpathealthcare

/**
 * Created by BRATIN KUNDU on 07-04-2018.
 */
class Patients{
    var id : Int =0
    var date : String=""
    var name : String =""
    var address : String =""
    var description : String = ""

    constructor(id:Int,date:String,name:String,address:String,description:String)
    {
        this.id=id
        this.date =date
        this.name=name
        this.address=address
        this.description=description
    }
    constructor()
    {

    }
}