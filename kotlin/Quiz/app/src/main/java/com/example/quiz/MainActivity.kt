package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bstart = findViewById<Button>(R.id.start)

        bstart.setOnClickListener {
            Toast.makeText(applicationContext,"เริ่มทำการทดสอบ Quiz", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,index::class.java))
        }
    }
}