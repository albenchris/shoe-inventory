package com.example.shoeinventorymanagement.ui.shoes.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoeinventorymanagement.data.Shoe
import com.example.shoeinventorymanagement.data.ShoeRepository
import kotlinx.coroutines.launch

class AddShoeViewModel(private val repository: ShoeRepository) : ViewModel() {

    fun insert(shoe: Shoe) = viewModelScope.launch {
        repository.insert(shoe)
    }

}