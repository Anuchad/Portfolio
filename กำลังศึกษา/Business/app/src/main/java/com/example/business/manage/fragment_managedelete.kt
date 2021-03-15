package com.example.business.manage

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.business.R
import com.example.business.User
import com.example.business.`interface`.IRecycleViewClick
import kotlinx.android.synthetic.main.fragment_managedelete.*
import com.example.business.manage.UserView

class fragment_managedelete : Fragment(),IRecycleViewClick  {
    private  lateinit var usersVM: UserView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,   
        savedInstanceState: Bundle?
    ): View? {

         usersVM = ViewModelProvider(this).get(UserView::class.java)
        return inflater.inflate(R.layout.fragment_managedelete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersVM.Read()

        val div = DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        recycleviewdel.addItemDecoration(div)

        val adt = adt()
        adt.ItemClick = this
        recycleviewdel.adapter = adt
        recycleviewdel.layoutManager = LinearLayoutManager(context)

        usersVM.userLists.observe(viewLifecycleOwner, Observer {
            adt.setuserList(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onRecycleViewItemClick(view: View, u: User) {
        when(view.id){
            R.id.del ->{
                AlertDialog.Builder(requireContext()).also {
                    it.setTitle("คุณต้องการลบข้อมูลลูกค้าใช่หรือไม่")
                    it.setPositiveButton("Yes"){ dialog,which ->
                        usersVM.Delete(u)
                    }
                }.create().show()
            }
        }
    }

}