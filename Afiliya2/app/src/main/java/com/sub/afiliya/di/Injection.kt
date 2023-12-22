package com.sub.afiliya.di

import com.sub.afiliya.data.ItemsRepository

object Injection {
    fun provideRepository(): ItemsRepository {
        return ItemsRepository.getInstance()
    }
}