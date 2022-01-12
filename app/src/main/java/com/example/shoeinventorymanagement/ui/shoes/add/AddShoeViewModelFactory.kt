package com.example.shoeinventorymanagement.ui.shoes.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoeinventorymanagement.data.ShoeRepository
import java.lang.IllegalArgumentException

class AddShoeViewModelFactory(private val repository: ShoeRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddShoeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddShoeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}