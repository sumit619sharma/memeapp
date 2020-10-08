package com.sumit.memeshare

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogIn : AppCompatActivity() {
    lateinit var etphone: EditText
    lateinit var etpassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtforgotpassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "6260740065"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_log_in)
        if(isLoggedIn){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"
        etphone = findViewById(R.id.etphone)
        etpassword = findViewById(R.id.etpasswrd)
        btnLogin = findViewById(R.id.btnlogin)
        txtforgotpassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
            val mobilenumber = etphone.text.toString()
            val password = etpassword.text.toString()
            var nameofavngr = "Meme"

            val intent = Intent(this, MainActivity::class.java)


            if (mobilenumber == validMobileNumber) {
                if (password == validPassword[0]) {

                    nameofavngr = "Meme"
                    savePreferences(nameofavngr)
                    startActivity(intent)

                }else{
                    Toast.makeText(this, "kyu time waste kra h", Toast.LENGTH_LONG)
                        .show()
                }


            } else {
                Toast.makeText(this, "kyu time waste kra h", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLooggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }

}