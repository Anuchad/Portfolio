package com.example.business

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.business.Admin
import com.google.firebase.database.FirebaseDatabase



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnlogin = findViewById<Button>(R.id.btnlogin)

        btnlogin.setOnClickListener {
//            val database = FirebaseDatabase.getInstance()
//            val myRef = database.getReference("test3")
//
//            myRef.setValue("Hello, World!")

            var intent = Intent(this, Admin::class.java)
            startActivity(intent)
            finish()

//            startActivity(Intent(this@MainActivity, Admin::class.java))
        }
    }
}