package com.example.tugas2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

var username1Input : String = ""
var password1Input : String = ""
 var usernameInput : String?=null
    var passwordInput :String?=null
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    btnLog.setOnClickListener {

        login()
    }
    ambilData()
}

    private fun ambilData() {
        val bundle = intent.extras

         usernameInput  = bundle?.getString("username")
         passwordInput = bundle?.getString("password")



    }
private fun login() {
    username1Input = editUser1.text.toString()
    password1Input = editPass1.text.toString()

    when{
        username1Input.isEmpty() -> editUser1.error = "Username tidak boleh kosong"
        password1Input.isEmpty() -> editPass1.error = "Password tidak boleh kosong"

        else -> {
            if (username1Input.equals(usernameInput) && password1Input.equals(passwordInput))
            tampilToast("Berhasil Log In")
            menuHome()
        }
    }

}

private fun menuHome() {

    val intent = Intent(this, HomeActivity::class.java)
    val bundle = Bundle()
    bundle.putString("username", username1Input)
    bundle.putString("password", password1Input)

    intent.putExtras(bundle)
    startActivity(intent)

}
private fun tampilToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
}