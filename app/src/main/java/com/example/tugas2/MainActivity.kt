package com.example.tugas2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val usernameInput : String = ""
    val passwordInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            menuLogin()

        }
    }

    private fun menuLogin() {

        val intent = Intent(this, LoginActivity::class.java)
        val bundle = Bundle()
        bundle.putString("username", usernameInput)
        bundle.putString("password", passwordInput)

        intent.putExtras(bundle)
        startActivity(intent)

    }
    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}