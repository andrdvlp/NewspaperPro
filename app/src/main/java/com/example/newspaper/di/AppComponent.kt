package com.example.newspaper.di

import com.example.newspaper.di.modules.DatabaseModule
import com.example.newspaper.di.modules.DomainModule
import com.example.newspaper.di.modules.RemoteModule
import com.example.newspaper.viewmodel.DetailsFragmentViewModel
import com.example.newspaper.viewmodel.FavoritesFragmentViewModel
import com.example.newspaper.viewmodel.HomeFragmentViewModel
import com.example.newspaper.viewmodel.SettingsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)

interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(detailsFragmentViewModel: DetailsFragmentViewModel)
    fun inject(favoritesFragmentViewModel: FavoritesFragmentViewModel)
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}