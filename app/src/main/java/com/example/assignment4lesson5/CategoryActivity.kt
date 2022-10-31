package com.example.assignment4lesson5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.w3c.dom.Text
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val bundle = intent.extras
        val email = bundle!!.getString("user", "")
        initView(email)

    }

    fun initView(email: String) {
        var emailTextView: TextView = findViewById(R.id.email)
        emailTextView.text = email
    }

    fun onclick_image(imageView: View) {
        Toast.makeText(
            this,
            "You have chosen the " + imageView.contentDescription + " category of shopping",
            Toast.LENGTH_LONG
        ).show()
    }


}