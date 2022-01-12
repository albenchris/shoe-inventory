package com.example.shoeinventorymanagement.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ShoeRepository(private val shoeDao: ShoeDao) {

//    val allShoes: Flow<MutableList<Shoe>> = shoeDao.getAllShoes()
    val allShoes: Flow<List<Shoe>> = shoeDao.getAllShoes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(shoe: Shoe) {
        shoeDao.insert(shoe)
    }
}