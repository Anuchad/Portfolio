package com.example.business.manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.business.R
import com.example.business.User
import com.example.business.`interface`.IRecycleViewClick
import kotlinx.android.synthetic.main.rv_row.view.*

class adt: RecyclerView.Adapter<adt.UserView>() {
    var ItemClick:IRecycleViewClick? = null
    private var userList = mutableListOf<User>()

    override fun getItemCount() = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserView (
        LayoutInflater.from(parent.context).inflate(R.layout.rv_row,parent,false)
    )

    class UserView(val view:View):RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: UserView, position: Int) {
        holder.view.tvname.text = userList[position].firstname
        holder.view.tvlastname.text = userList[position].lastname
        holder.view.tvphone.text = userList[position].phone.toString()
        holder.view.tvposition.text = userList[position].position
        holder.view.tvemail.text = userList[position].email
        holder.view.tvpassword.text = userList[position].password

        holder.view.del.setOnClickListener {
            ItemClick?.onRecycleViewItemClick(it,userList[position])
        }
    }

    fun setuserList(u:List<User>){
        this.userList = u as MutableList<User>
        notifyDataSetChanged()
    }

}