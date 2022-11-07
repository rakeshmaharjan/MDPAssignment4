package com.example.assignment4lesson5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.w3c.dom.Text
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val bundle = intent.extras
        val email = bundle!!.getString("user", "")
        initView(email)

    }

    private fun initView(email: String) {
        val emailTextView: TextView = findViewById(R.id.email)
        emailTextView.text = email
    }

    fun onclick_image(imageView: View) {

        val electronicItemList = ArrayList<Product>()
        val product1 = Product(
            "Latitude 5520 Laptop",
            1000.0,
            "Grey",
            "" + R.drawable.latitude5520,
            "item1",
            "Latitude 5520 on the market"
        )

        val product2 = Product(
            "Iphone 14",
            1280.25,
            "Default",
            ""+R.drawable.apple14inch,
            "item2",
            "Trending Iphone 14 in the market"
        )

        val product3 = Product(
            "Hp Pavilion",
            950.00,
            "Blue",
            ""+R.drawable.hppavilion,
            "item3",
            "Suitable for general purpose"
        )
        val product4 = Product(
            "XPS Desktop",
            3800.00,
            "Grey",
            ""+R.drawable.xpsdesktop,
            "item4",
            "Heavy duty desktop for gamers and programmers"
        )

        electronicItemList.add(product1)
        electronicItemList.add(product2)
        electronicItemList.add(product3)
        electronicItemList.add(product4)

        val intent = Intent(this, RecyclerListView::class.java)
        intent.putExtra("productList", Gson().toJson(electronicItemList))
        startActivity(intent)
    }
}