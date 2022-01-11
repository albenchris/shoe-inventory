package com.example.shoeinventorymanagement

import android.app.Application
import com.example.shoeinventorymanagement.data.ShoeRepository
import com.example.shoeinventorymanagement.data.ShoeRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ShoeApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ShoeRoomDatabase.getDatabase(this, applicationScope) }
//    val database by lazy { ShoeRoomDatabase.invoke(this) }

    val repository by lazy { ShoeRepository(database.shoeDao()) }
}