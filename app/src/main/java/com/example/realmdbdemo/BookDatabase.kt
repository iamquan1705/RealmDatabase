package com.example.realmdbdemo

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class BookDatabase {
    companion object {
        private val config = RealmConfiguration.Builder(schema = setOf(Book::class))
            .name("Book_Database")
            .schemaVersion(7)
//            .initialData(object : InitialDataCallback {
//                override fun MutableRealm.write() {
//                    val book = Book()
//                    copyToRealm(book)
//                }
//            })
            .deleteRealmIfMigrationNeeded()
            .build()
        var realm: Realm = Realm.open(config)
    }
}