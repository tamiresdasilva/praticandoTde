package com.example.praticandotde

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.praticandotde.databinding.ProductItemBinding

class ProductAdapter(

    private val items: MutableList<Product>, private val goToDetail: (item: Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {holder.bind(items[position])}

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product

            binding.root.setOnClickListener{
                goToDetail(product)
            }

            binding.root.setOnLongClickListener {
                showPopUpMenu(it, product)
                true
            }
        }
    }


    private fun showPopUpMenu(view: View, product: Product) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener { item ->
                when (item.itemId){
                    R.id.deletar -> {
                        removeItem(product)
                        true
                    }
                    else -> false
                }
            }
            inflate(R.menu.menu_popup)
            show()
        }
    }
    private fun removeItem(product: Product){
        items.remove(product)
        notifyDataSetChanged()
    }
}