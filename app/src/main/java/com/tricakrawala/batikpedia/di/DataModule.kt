package com.tricakrawala.batikpedia.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tricakrawala.batikpedia.MainViewModel
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.pref.UserPreference
import com.tricakrawala.batikpedia.pref.dataStore
import com.tricakrawala.batikpedia.screen.home.HomeViewModel
import com.tricakrawala.batikpedia.screen.katalog.KatalogViewModel
import com.tricakrawala.batikpedia.screen.provinsi.ProvinsiViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val dataModule = module {
    single { provideDataStore(androidContext()) }
    single { UserPreference(get()) }
    single { BatikRepository(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { KatalogViewModel(get()) }
    viewModel { ProvinsiViewModel(get()) }
}

fun provideDataStore(context: Context): DataStore<Preferences> {
    return context.dataStore
}