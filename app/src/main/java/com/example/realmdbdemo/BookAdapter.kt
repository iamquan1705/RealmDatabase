package com.example.realmdbdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.realmdbdemo.databinding.ItemBookBinding

class BookAdapter(
    private var onClickItem: (Long) -> Unit,
    private var onLongClick: (Long) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private var listBook = arrayListOf<Book>()
    fun submitData(data: List<Book>) {
        listBook.clear()
        listBook.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBook[position])
        holder.itemView.setOnClickListener {
            onClickItem(listBook[position].id)
        }
        holder.itemView.setOnLongClickListener {
            onLongClick(listBook[position].id)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int = listBook.size


    class ViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.book = book
        }
    }
}