package com.example.realmdbdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdbdemo.BookDatabase.Companion.realm
import com.example.realmdbdemo.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val book = Book().apply {
                name = binding.edtNameBook.text.toString()
                author = binding.edtAuthor.text.toString()
            }
            realm.writeBlocking {
                copyToRealm(book)
            }
            finish()
        }
    }
}