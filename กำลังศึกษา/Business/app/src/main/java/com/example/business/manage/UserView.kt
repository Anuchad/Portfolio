package com.example.business.manage

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.business.FB.UserNode
import com.example.business.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserView:ViewModel() {
    var fb = FirebaseDatabase.getInstance().getReference(UserNode)

    private val _result = MutableLiveData<Exception?>()
    val result:LiveData<Exception?>
        get() = _result

    private val _userLists = MutableLiveData<List<User>>()
    val userLists:LiveData<List<User>>
        get() = _userLists

    fun Add(u : User){
        u.userid = fb.push().key


    fb.child(u.userid!!).setValue(u).addOnCompleteListener {
        if(it.isSuccessful){
            _result.value = null
        }else{
            _result.value = it.exception!!
        }
    }
    }

    fun Read(){
        fb.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val u = mutableListOf<User>()
                    for(data in snapshot.children){
                        val user = data.getValue(User::class.java)
                        user?.userid = data.key
                        user?.let{u.add(it)}
                    }
                    _userLists.value = u
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun Delete(u:User){
        fb.child(u.userid!!).setValue(null)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        _result.value = null
                    }else{
                        _result.value = it.exception
                    }
                }
    }

}