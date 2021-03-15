package com.example.business

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.business.R
import com.example.business.fragment_Manage

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val fragment = fragment_Manage()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Frameview,fragment)
        transaction.commit()



    }



}