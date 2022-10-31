package com.example.assignment4lesson5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var users = ArrayList<User>()
    private lateinit var emailAddress : EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User("Jojo", "Para", "jojo", "test", "jojo@test.com"))
        users.add(User("Pojo", "Para", "pojo", "test", "pojo@test.com"))
        users.add(User("Dodo", "Para", "dodo", "test", "dodo@test.com"))
        users.add(User("Hero", "Para", "hero", "test", "hero@test.com"))
        users.add(User("Coffee", "Para", "coffee", "test", "coffee@test.com"))

        initView()
    }

    fun initView()
    {
        emailAddress = findViewById(R.id.emailAddress)
        password = findViewById(R.id.password)
    }

    fun onclick_signin(view: View) {
        users.forEach {
            if (it.email == emailAddress.text.toString() && it.password == password.text.toString())
            {
                startActivity(Intent(this,CategoryActivity::class.java).apply {
                    putExtra("user",it.email)
                })

            }
        }

    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: User = result.data?.extras?.get("user") as User
                users.add(data)
            }
        }
    fun onclick_createaccount(view: View)
    {
        resultLauncher.launch(Intent(this, register::class.java))
    }
}