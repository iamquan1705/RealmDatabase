package com.example.realmdbdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.realmdbdemo.BookDatabase.Companion.realm
import com.example.realmdbdemo.databinding.ActivityMainBinding
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initOnClick()
        initRc()
    }

    private fun initRc() {
        adapter = BookAdapter(onClickItem = onClickItem(), onLongClick = onLongClick())
        adapter.submitData(getAllData())
        binding.rcBook.adapter = adapter
    }

    private fun onClickItem(): (Long) -> Unit = {
        var intent = Intent(this, EditActivity::class.java)
        intent.putExtra("ID_EDIT", it)
        startActivity(intent)
    }

    private fun onLongClick(): (Long) -> Unit = {
        lifecycleScope.launch(Dispatchers.IO) {
            realm.write {
                val book = this.query<Book>("id== $it").find().first()
                delete(book)
            }
        }
    }

    private fun initOnClick() {
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        binding.btnGetData.setOnClickListener {
            getAllData()
        }
    }

    private fun getAllData(): List<Book> {
        return realm.query<Book>().find()
    }
}