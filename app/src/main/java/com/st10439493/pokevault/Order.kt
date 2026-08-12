package com.st10439493.pokevault

class Order() {
    lateinit var productName: String
    lateinit var customerName: String
    lateinit var customerPhone: String
    lateinit var orderDate: String
    //constructor
    constructor(pName:String): this()
    {
        productName = pName
    }
    constructor(pName:String, cName:String, cPhone:String, oDate:String):
            this(pName)
    {
        customerName = cName
        customerPhone = cPhone
        orderDate = oDate
    }


}