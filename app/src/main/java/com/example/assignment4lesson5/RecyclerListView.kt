package com.example.assignment4lesson5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.lang.reflect.Type

class RecyclerListView : AppCompatActivity() , ProductClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_list_view)

        val type: Type = object : TypeToken<List<Product?>?>() {}.type

        val productList: ArrayList<Product> = Gson().fromJson(
            intent.getStringExtra("productList"),
            type)

        val recyclerProductItem : RecyclerView = findViewById(R.id.recyclerCategoryItem)
        recyclerProductItem.layoutManager = LinearLayoutManager(this)
        val adapter = ProductListAdapter(productList, this)
        recyclerProductItem.adapter = adapter
    }

    override fun onProductItemClicked(product: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product", Gson().toJson(product))
        startActivity(intent)
    }
}