package com.example.praticandotde

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.praticandotde.databinding.FragmentCreateProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateProductFragment : Fragment() {
    private lateinit var binding: FragmentCreateProductBinding
    //private lateinit var productViewModel: ProductViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //productViewModel = ViewModelProvider(this)[ProductViewmodel::class.java]

        binding.btnSalvar.setOnClickListener {
            val product = Product(
                name = binding.inputName.text.toString(),
                price = binding.inputPrice.text.toString(),
                urlImage = binding.inputUrlProduto.text.toString()
            )

            //productViewModel.addProduct(product)

            findNavController().navigate(R.id.action_createProductFragment_to_homeFragment)
        }
    }

}