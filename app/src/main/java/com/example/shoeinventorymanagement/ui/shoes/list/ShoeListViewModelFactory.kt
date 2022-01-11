package com.example.shoeinventorymanagement.ui.shoes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoeinventorymanagement.data.ShoeRepository
import java.lang.IllegalArgumentException

class ShoeListViewModelFactory(private val repository: ShoeRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoeListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}