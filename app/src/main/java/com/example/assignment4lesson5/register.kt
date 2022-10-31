package com.example.assignment4lesson5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {

    private lateinit var firstname: EditText;
    private lateinit var lastname: EditText;
    private lateinit var email: EditText;
    private lateinit var password: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()

    }

    fun initView() {
        firstname = findViewById(R.id.firstName)
        lastname = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }

    fun onclick_createaccount(view: View) {

        if (firstname.text.isEmpty() || lastname.text.isEmpty() || email.text.isEmpty() || password.text.isEmpty())
            Toast.makeText(this, "Fill All required Fields", Toast.LENGTH_SHORT).show()

        val returnData = Intent()
        returnData.putExtra(
            "user",
            User(
                firstname.text.toString(),
                lastname.text.toString(),
                email.text.toString(),
                password.text.toString(),
                email.text.toString()
            )
        )
        setResult(RESULT_OK, returnData)
        finish()
    }

}