package com.example.praticandotde.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.praticandotde.R
import com.example.praticandotde.commons.utils.Resultado
import com.example.praticandotde.presentation.adapters.ProductAdapter
import com.example.praticandotde.databinding.FragmentHomeBinding
import com.example.praticandotde.presentation.viewmodels.ProductViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment<Product : Any> : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var productViewModel: ProductViewmodel
    private lateinit var adapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this)[ProductViewmodel::class.java]

        createAdapter()
        observers()
        productViewModel.fetchProducts()
    }

    private fun createAdapter() {
        adapter = ProductAdapter(
            goToDetails = ::goToDetail,
            removeItem = ::removeItem
        )

        binding.rcProduct.adapter = adapter
    }



    private fun observers() {
        productViewModel.products.observe(viewLifecycleOwner) { resultado ->
            when(resultado) {
                is Resultado.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rcProduct.visibility = View.GONE
                }

                is Resultado.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcProduct.visibility = View.VISIBLE
                    adapter.setUpList(resultado.data)
                }

                is Resultado.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rcProduct.visibility = View.GONE
                    Log.i("Erro", "erro")
                }
            }
        }
    }
    private fun removeItem(product: Product) {
        productViewModel.removeProduct(product)
    }
    private fun goToDetail(product: Product) {
        Log.i("produto", product.toString())
        val bundle = bundleOf("data" to product)
        findNavController().navigate(R.id.action_homeFragment_to_productDetailActivity, bundle)
    }
}