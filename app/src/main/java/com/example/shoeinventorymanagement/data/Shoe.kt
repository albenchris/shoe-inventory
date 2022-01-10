package com.example.shoeinventorymanagement.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoe_table")
data class Shoe(
    @PrimaryKey @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "brand") val brand : String,
    @ColumnInfo(name = "type") val type : String,
    @ColumnInfo(name = "price") val price : Int,
)
