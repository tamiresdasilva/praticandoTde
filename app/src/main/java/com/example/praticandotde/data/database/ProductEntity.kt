package com.example.praticandotde.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.praticandotde.data.Product

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: String,
    val urlImg: String
)

fun ProductEntity.mapperToProduct() =
    Product(name = this.name, price = this.price, urlImage = this.urlImg)
