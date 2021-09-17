package com.mariroco.appexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mariroco.appexamen.AppExamen.Companion.usersPref
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsername : EditText
    private lateinit var txtPassword : EditText
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView(){
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener { accessProfile() }
    }

    private fun accessProfile(){
        val user= txtUsername.text.toString()
        val pass= txtPassword.text.toString()

        if(usersPref.getWriter().isEmpty()){
            usersPref.saveReader("Reader")
            usersPref.savePassword("read123",true)
            usersPref.saveWriter("Writer")
            usersPref.savePassword("write123",false)
        }else{
            if (user == usersPref.getReader() && pass == usersPref.getPassword(true)){
                loadProfile(TRUE)
                clearEditText()
            }else if(user == usersPref.getWriter() && pass == usersPref.getPassword(false)){
                loadProfile(FALSE)
                clearEditText()
            }else{
                Toast.makeText(this,(R.string.txt_wrongCredentials),Toast.LENGTH_LONG).show()
            }
        }
        loadProfile(TRUE)

    }

    private fun loadProfile(type:Boolean){
        startActivity(Intent(this, UserProfile::class.java).apply {
            putExtra("type",type)
        })
    }

    fun clearEditText(){
        txtPassword.text=null
        txtUsername.text=null
    }
}