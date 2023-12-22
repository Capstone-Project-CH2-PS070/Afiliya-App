package com.sub.afiliya.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.silvy.subjetpack.data.ItemsRepository
import com.silvy.subjetpack.ui.screen.cart.CartViewModel
import com.silvy.subjetpack.ui.screen.detail.DetailItemViewModel
import com.silvy.subjetpack.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: ItemsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailItemViewModel::class.java)) {
            return DetailItemViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}