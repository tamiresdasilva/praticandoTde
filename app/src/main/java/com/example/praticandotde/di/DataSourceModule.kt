package com.example.praticandotde.di

import com.example.praticandotde.data.database.ProductDao
import com.example.praticandotde.data.datasources.ProductDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesProductDataSource(productDao: ProductDao): ProductDataSource {
        return ProductDataSource(productDao)
    }
}