package com.example.shoeinventorymanagement.data

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ShoeApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ShoeRoomDatabase.getDatabase(this, applicationScope) }

    val repository by lazy { ShoeRepository(database.shoeDao()) }
}