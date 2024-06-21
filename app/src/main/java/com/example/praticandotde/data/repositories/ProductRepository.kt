package com.example.praticandotde.data.repositories


import com.example.praticandotde.data.Product
import com.example.praticandotde.data.database.mapperToProduct
import com.example.praticandotde.data.datasources.ProductDataSource
import com.example.praticandotde.data.mapperToEntity
import javax.inject.Inject


class ProductRepository @Inject constructor(private val productDataSource: ProductDataSource) {
    fun fetchAllProducts(): List<Product> {
        return productDataSource
            .fetchAllProducts()
            .map { item -> item.mapperToProduct() }
    }

    suspend fun addProduct(product: Product) {
        productDataSource.addProduct(product.mapperToEntity())
    }

    suspend fun deleteProduct(product: Product) {
        productDataSource.deleteProduct(product.name)
    }
}