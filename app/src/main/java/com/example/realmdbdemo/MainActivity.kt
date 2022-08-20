package com.example.realmdbdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdbdemo.databinding.ActivityMainBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val config = RealmConfiguration.Builder(schema = setOf(Book::class))
            .build()
        realm = Realm.open(config)
        initOnClick()
    }

    private fun initOnClick() {
        binding.btnAdd.setOnClickListener {
            realm.writeBlocking {
                copyToRealm(Book().apply {
                    name = "abc"
                    author = "Quan"
                })
            }
        }
        binding.btnGetData.setOnClickListener {
            getAllData()
        }
    }


    private fun getAllData() {
        val books: RealmResults<Book> = realm.query<Book>().find()
        books.forEach {
            Log.d("iamquan1705", it.name)
        }
    }
}