package com.example.shoeinventorymanagement.ui.shoes.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.shoeinventorymanagement.data.Shoe
import com.example.shoeinventorymanagement.data.ShoeRepository
import kotlinx.coroutines.launch

class ShoeListViewModel(private val repository: ShoeRepository) : ViewModel() {

//    val allShoes: LiveData<MutableList<Shoe>> = repository.allShoes.asLiveData()
    val allShoes: LiveData<List<Shoe>> = repository.allShoes.asLiveData()

    fun insert(shoe: Shoe) = viewModelScope.launch {
        repository.insert(shoe)
    }
}