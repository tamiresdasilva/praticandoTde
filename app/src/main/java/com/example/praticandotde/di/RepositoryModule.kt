package com.example.praticandotde.di
//import com.example.praticandotde.data.datasources.ProductDao
import com.example.praticandotde.data.datasources.ProductDataSource
import com.example.praticandotde.data.repositories.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(productDataSource: ProductDataSource): ProductRepository {
        return ProductRepository(productDataSource)
    }
}