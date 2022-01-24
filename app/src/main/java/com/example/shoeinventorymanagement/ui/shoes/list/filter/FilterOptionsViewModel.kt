package com.example.shoeinventorymanagement.ui.shoes.list.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.shoeinventorymanagement.data.Shoe
import com.example.shoeinventorymanagement.data.ShoeRepository

class FilterOptionsViewModel(private val repository: ShoeRepository) : ViewModel() {

    val allShoes: LiveData<List<Shoe>> = repository.allShoes.asLiveData()

}