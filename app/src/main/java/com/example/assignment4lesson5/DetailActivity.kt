package com.example.assignment4lesson5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product: Product = Gson().fromJson(
            intent.getStringExtra("product"),
            Product::class.java)

        val imgLogo: ImageView = findViewById(R.id.imgLogo)
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvColor: TextView = findViewById(R.id.tvColor)
        val tvItemId: TextView = findViewById(R.id.tvItemId)
        val tvDescription: TextView = findViewById(R.id.tvDescription)

        Glide.with(this).load(product.image?.toInt()).into(imgLogo)

        tvTitle.text = product.title
        tvColor.text = "Color: " + product.color
        tvItemId.text = "Item Id: " + product.itemId
        tvDescription.text = product.desc
    }
}