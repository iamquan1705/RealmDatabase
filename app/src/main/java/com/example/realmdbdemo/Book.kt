package com.example.realmdbdemo

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Book : RealmObject {
    @PrimaryKey()
    var id: Int = 0
    var name: String = "Android Exam"
    var author: String = "Quan"
}