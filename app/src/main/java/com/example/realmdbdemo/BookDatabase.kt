package com.example.realmdbdemo

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class BookDatabase {
    companion object {
        private val config = RealmConfiguration.Builder(schema = setOf(Book::class))
            .build()
        var realm: Realm = Realm.open(config)
    }
}