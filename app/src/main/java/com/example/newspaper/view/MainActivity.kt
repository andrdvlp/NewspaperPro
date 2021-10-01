package com.example.newspaper.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newspaper.R
import com.example.newspaper.databinding.ActivityMainBinding
import com.example.newspaper.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Инициализируем объект
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Передаем его в метод
        setContentView(binding.root)

        //    initNavigation()

        //Зупускаем фрагмент при старте
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_placeholder, HomeFragment())
                .addToBackStack(null)
                .commit()
    }

//    private fun initNavigation() {
//        binding.bottomNavigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> {
//
//                }
//            }
//        }
//    }
}