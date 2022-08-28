package com.example.realmdbdemo

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.*

class Book : RealmObject {
    @PrimaryKey()
    var id: Long = System.currentTimeMillis()
    var name: String = "Android Exam"
    var author: String = "Quan"
}