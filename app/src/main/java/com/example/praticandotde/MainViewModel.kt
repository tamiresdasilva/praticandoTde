package com.example.praticandotde


import androidx.lifecycle.ViewModel
import com.example.praticandotde.data.Product
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
class MainViewModel : ViewModel() {
    private val list = mutableListOf(
        Product(
            urlImage = "https://pubimg.band.uol.com.br/files/2c0933a3fb3b6946e074.webp",
            name = "Coxinha",
            price = "5,00".convertToMoneyWithSymbol()
        ),
        Product(
            urlImage = "https://i.pinimg.com/736x/dd/02/a5/dd02a551c78b4afa2f795e175fe5f617.jpg",
            name = "Pastel",
            price = "8,00".convertToMoneyWithSymbol()
        ),
        Product(
            urlImage = "https://cdn.awsli.com.br/600x450/1847/1847175/produto/89754267/b94ac2c71a.jpg",
            name = "Kibe",
            price = "4,00".convertToMoneyWithSymbol()
        ),
        Product(
            urlImage = "https://www.grupopq.com.br/wp-content/uploads/2023/09/SITE2-1024x1024.jpg",
            name = "Esfiha",
            price = "7,00".convertToMoneyWithSymbol()
        ),
        Product(
            urlImage = "https://pubimg.band.uol.com.br/files/b84f58033b0b179702b5.png",
            name = "Croquete",
            price = "3,50".convertToMoneyWithSymbol()
        )

    )
    fun getProducts() = list
}
