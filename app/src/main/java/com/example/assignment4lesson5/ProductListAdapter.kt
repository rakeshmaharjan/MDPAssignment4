package com.example.assignment4lesson5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductListAdapter(
    private val products: List<Product>,
    private val clickLister: ProductClickListener
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val tvPrice: TextView = view.findViewById(R.id.tvPrice)
            val tvColor: TextView = view.findViewById(R.id.tvColor)
            val imgLogo: ImageView = view.findViewById(R.id.imgLogo)

            tvTitle.text = product.title
            tvPrice.text = "$" + product.price
            tvColor.text = product.color
            Glide.with(view.context).load(product.image?.toInt()).into(imgLogo)

            view.setOnClickListener {
                clickLister.onProductItemClicked(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products.get(position))
    }

    override fun getItemCount(): Int {
        return products.size
    }
}