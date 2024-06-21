package com.example.praticandotde

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.praticandotde.data.Product
import com.example.praticandotde.databinding.ActivityProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")

@AndroidEntryPoint
class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        configureToolbar("Detalhe do produto", true)

        val productBundle = if (Build.VERSION.SDK_INT >= 33) {
            intent?.getSerializableExtra("data", Product::class.java)
        } else {
            intent?.getSerializableExtra("data") as? Product
        }

        productBundle?.let { product ->
            binding.product = product
        }
    }
}