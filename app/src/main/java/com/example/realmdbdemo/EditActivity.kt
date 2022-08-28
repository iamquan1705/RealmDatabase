package com.example.realmdbdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdbdemo.BookDatabase.Companion.realm
import com.example.realmdbdemo.databinding.ActivityEditBinding
import io.realm.kotlin.ext.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idEdit = intent.getLongExtra("ID_EDIT", 0)
        val book = realm.query<Book>("id== $idEdit").first().find()
        binding.bookEdit = book
        binding.btnEdit.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val newBook = Book().apply {
                    id = idEdit
                    name = binding.edtNameBook.text.toString()
                    author = binding.edtAuthor.text.toString()
                }
                realm.write {
                    var book = this.query<Book>("id== $idEdit").first().find()
                    book?.name = newBook.name
                    book?.author  = newBook.author
                }
            }
            finish()
        }

    }


}