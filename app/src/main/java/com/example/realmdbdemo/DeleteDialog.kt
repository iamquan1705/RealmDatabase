package com.example.realmdbdemo

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.example.realmdbdemo.databinding.DialogDeleteBinding

class DeleteDialog(context: Context, private var onCLickDelete: () -> Unit) : Dialog(context) {
    private var binding: DialogDeleteBinding

    init {
        binding = DialogDeleteBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnDelete.setOnClickListener {
            dismiss()
            onCLickDelete()
        }
        binding.btnExit.setOnClickListener {
            dismiss()
        }
    }

}