package com.example.terminalfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<viewholder>() {



    val title = arrayListOf<String>("Name : Hassan Muhammad Sabir, Registration : 045 , Phone:123")
    override fun getItemCount(): Int {
        return title.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {


        val linflater = LayoutInflater.from(parent?.context)
        val newinf = linflater.inflate(R.layout.new_layout,parent,false)
        return viewholder(newinf)


    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val titlev = title.get(position)
        holder.v.textView.text=titlev
    }

}
class  viewholder(val v: View):RecyclerView.ViewHolder(v){

}