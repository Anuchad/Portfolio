package com.example.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_manager_add.*


class fragment_managerAdd : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fgm = inflater.inflate(R.layout.fragment_manager_add, container, false)

        var etname = fgm.findViewById<EditText>(R.id.etname)
        var etlastname = fgm.findViewById<EditText>(R.id.etlastname)
        var submit = fgm.findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            if (etname.text.isEmpty() || etlastname.text.isEmpty() || etphone.text.toString().isEmpty() || etposition.text.toString().isEmpty() || etemail.text.toString().isEmpty() || etpassword.toString().isEmpty() ) {
                Toast.makeText(activity,"กรุณากรอกข้อมูลให้ครบถ้วน",Toast.LENGTH_SHORT).show()
            } else {
                saveuser()
                clear()
            }
        }
        return fgm
    }



    private fun saveuser() {

        var firstname = etname.text.toString().trim()
        var lastname = etlastname.text.toString().trim()
        var phone = etphone.text.toString().toInt()
        var position = etposition.text.toString().trim()
        var email = etemail.text.toString().trim()
        var password = etpassword.text.toString().trim()

        val ref = FirebaseDatabase.getInstance().getReference("users")
        val userid: String? = ref.push().key

        val user = User(userid.toString(), firstname,lastname,phone,position,email,password)


        ref.child(userid.toString()).setValue(user).addOnCompleteListener {
            Toast.makeText(activity, "successfully", Toast.LENGTH_SHORT).show()
            }
        }

        private fun clear(){
            etname.setText("")
            etlastname.setText("")
            etphone.setText("")
            etposition.setText("")
            etemail.setText("")
            etpassword.setText("")
    }



}



