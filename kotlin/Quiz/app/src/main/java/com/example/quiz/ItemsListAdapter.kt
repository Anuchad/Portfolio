package com.example.quiz

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.item_list_view.*


class ItemsListAdapter(var context: Context, var arrayList: ArrayList<Itemlist>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = View.inflate(context,R.layout.item_list_view,null)

        var tsection:TextView = view.findViewById(R.id.section)
        var tquestion:TextView = view.findViewById(R.id.question)
       
        var carticle1:RadioButton = view.findViewById(R.id.article1)
        var carticle2:RadioButton = view.findViewById(R.id.article2)
        var carticle3:RadioButton = view.findViewById(R.id.article3)
        var carticle4:RadioButton = view.findViewById(R.id.article4)
        var itemList:Itemlist = arrayList.get(position)

        tsection.text = itemList.section.toString()
        tquestion.text = itemList.question
        carticle1.text = itemList.article1
        carticle2.text = itemList.article2
        carticle3.text = itemList.article3
        carticle4.text = itemList.article4




        return view!!
    }
//    private class ViewHolder{
//        private var checkBox:CheckBox? = null
//
//       public ViewHolder(View v){
//           checkBox =
//       }
//
//    }

}