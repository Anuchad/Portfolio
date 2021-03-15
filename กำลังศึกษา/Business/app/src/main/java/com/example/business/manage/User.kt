package com.example.business

import com.google.firebase.database.Exclude

data class User (
     @get:Exclude
     var userid:String? = null ,
     var firstname:String? = null,
     var lastname:String? = null ,
     var phone:Int? = null ,
     var position:String? = null ,
     var email:String? = null ,
     var password:String? = null
)