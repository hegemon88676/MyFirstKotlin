package com.example.recylerviewkotlin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfmi.News
import com.example.androidfmi.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newsList : ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//    private lateinit var mListener : onItemClickListener

//    interface onItemClickListener{
//        fun onItemClick(position : Int)
//    }

//    fun setOnItemClickListener(listener: onItemClickListener){
//
//        mListener = listener
//
//    }

//    fun deleteItem(i : Int){
//        newsList.removeAt(i)
//        notifyDataSetChanged()
//    }

//    fun addItem(i : Int, news : News){
//        newsList.add(i,news)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.title.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    }

}
