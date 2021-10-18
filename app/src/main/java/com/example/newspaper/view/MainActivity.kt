package com.example.newspaper.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newspaper.R
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.databinding.ActivityMainBinding
import com.example.newspaper.view.fragments.DetailsFragment
import com.example.newspaper.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Инициализируем объект
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Передаем его в метод
        setContentView(binding.root)

//            initNavigation()

        //Зупускаем фрагмент при старте
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_placeholder, HomeFragment())
                .addToBackStack(null)
                .commit()
    }

    fun launchDetailsFragment(article: Article) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("article", article)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

//    private fun initNavigation() {
//        binding.bottomNavigation.setOnNavigationItemSelectedListener {
//
//            when (it.itemId) {
//                R.id.home -> {
//                    val tag = "home"
//                    val fragment = checkFragmentExistence(tag)
//                    //В первом параметре, если фрагмент не найден и метод вернул null, то с помощью
//                    //элвиса мы вызываем создание нвого фрагмента
//                    changeFragment( fragment?: HomeFragment(), tag)
//                    true
//                }
//                else -> false
//            }
//        }
//    }

//    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)
//
//    private fun changeFragment (fragment: Fragment, tag: String) {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_placeholder, fragment, tag)
//                .addToBackStack(null)
//                .commit()
//
//    }

}