package com.example.sitask4

data class UserData2(
    val data1:String,
    val data2:String,
    val data3:String,
    val data4: String,
    val data5: String,
)

data class user(
    val count:Int,
    val data: List<UserData2>
)
