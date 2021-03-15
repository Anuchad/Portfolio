package com.example.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.business.manage.fragment_managedelete


class fragment_Manage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        // Inflate the layout for this fragment
        val frgm = inflater.inflate(R.layout.fragment_manage,container,false)
        val btnadd = frgm.findViewById<ImageView>(R.id.manage_add)
        val btndel = frgm.findViewById<ImageView>(R.id.manage_delete)

        btnadd.setOnClickListener{
            val fragment = fragment_managerAdd()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.Frameview,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        btndel.setOnClickListener {
            val fragment = fragment_managedelete()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.Frameview,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }



        return frgm
    }


}
