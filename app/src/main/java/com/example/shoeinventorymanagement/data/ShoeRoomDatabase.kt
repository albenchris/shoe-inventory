package com.example.shoeinventorymanagement.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = arrayOf(Shoe::class), version = 1, exportSchema = false)
abstract class ShoeRoomDatabase : RoomDatabase() {

    abstract fun shoeDao(): ShoeDao

    companion object {

        @Volatile
        private var INSTANCE : ShoeRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : ShoeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoeRoomDatabase::class.java,
                    "shoe_database"
                )
                    .addCallback(ShoeDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    private class ShoeDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.shoeDao())
                }
            }
        }

        suspend fun populateDatabase(shoeDao: ShoeDao) {
            shoeDao.deleteAll()

            var uniqueID = UUID.randomUUID().toString()
            var shoe = Shoe(
                id = uniqueID,
                brand = "Nike",
                type = "Running Shoes",
                price = 270
            )
            shoeDao.insert(shoe)

            uniqueID = UUID.randomUUID().toString()
            shoe = Shoe(
                id = uniqueID,
                brand = "Nike",
                type = "Running Shoes",
                price = 280
            )
            shoeDao.insert(shoe)

//            !!!!!!!!!!!!!!!!!!!!!!
//            !!! ADD MORE SHOES !!!
//            !!!!!!!!!!!!!!!!!!!!!!
        }
    }
}