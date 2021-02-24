 package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.item_list_view.*

class index : AppCompatActivity() {

    private  var listView:ListView ? = null
    private  var itemListAdapter:ItemsListAdapter ? = null
    private var arrayList:ArrayList<Itemlist> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

//        if(section.text == "10"){
            listView = findViewById(R.id.quiz_list)
            arrayList = ArrayList()
            arrayList = setDataArrayList()
            itemListAdapter = ItemsListAdapter(applicationContext, arrayList!!)
            listView?.adapter = itemListAdapter

        submit.setOnClickListener {

            Toast.makeText(applicationContext,"ส่งคำตอบเรียบร้อย", Toast.LENGTH_SHORT).show()
        }
       

//        listView.setOnItemClickListener { parent, view, position, id ->
//            article.setOnCheckedChangeListener(
//                    RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                        val radio: RadioButton = findViewById(checkedId)
//                        Toast.makeText(applicationContext," On checked change :"+
//                                " ${radio.text}",
//                                Toast.LENGTH_SHORT).show()
//                    })
        }




//        article1.setOnCheckedChangeListener { buttonView, isChecked ->
//            Toast.makeText(applicationContext,"เhhhh", Toast.LENGTH_SHORT).show()
//        }

//        listView?.setOnItemClickListener { parent, view, position, id ->
//            if (position == 0){
//                Toast.makeText(applicationContext,"เhhhh", Toast.LENGTH_SHORT).show()
//            }
//        }
       
//        }else{
//            listView = findViewById(R.id.quiz_list)
//            arrayList = ArrayList()
//            arrayList = setDataArrayList()
//            itemListAdapter = ItemsListAdapter(applicationContext, arrayList!!)
//            listView?.adapter = itemListAdapter
//        }


//    }




    private fun setDataArrayList() : ArrayList<Itemlist>{

        var arrayList:ArrayList<Itemlist> = ArrayList()
        arrayList.add(Itemlist(1,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(2,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(3,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(4,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(5,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(6,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(7,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(8,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(9,"kotlin","A","B","C","D"))
        arrayList.add(Itemlist(10,"kotlin","A","B","C","D"))
        return  arrayList!!

    }
}