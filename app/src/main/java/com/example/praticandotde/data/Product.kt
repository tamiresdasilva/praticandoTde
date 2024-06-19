package com.example.praticandotde.data

import com.example.praticandotde.data.database.ProductEntity
import java.io.Serializable

data class Product(
    val urlImage: String,
    val name: String,
    val price: String
) : Serializable

fun Product.mapperToEntity() =
    ProductEntity(name = this.name, price = this.price, urlImg = this.urlImage)