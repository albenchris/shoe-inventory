package com.example.shoeinventorymanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shoeinventorymanagement.data.Shoe
import com.example.shoeinventorymanagement.ui.shoes.list.ShoeListViewModel
import com.example.shoeinventorymanagement.ui.shoes.list.ShoeListViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    private var allShoesList: ArrayList<Shoe> = arrayListOf<Shoe>()
    private val shoeListViewModel : ShoeListViewModel by viewModels {
        ShoeListViewModelFactory((application as ShoeApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment

        navController = navHostFragment.navController

        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setupWithNavController(navController)

        setupActionBarWithNavController(navController)

        shoeListViewModel.allShoes.observe(this) { shoes ->
            allShoesList.addAll(shoes)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}