package com.aman.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aman.demo.databinding.InnerRowLayoutBinding
import org.json.JSONArray

class InnerRecyclerAdapter(private val jsonArray: JSONArray) :
    RecyclerView.Adapter<InnerRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = InnerRowLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = jsonArray.length()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(jsonArray.getString(position))
    }

    inner class MyViewHolder(private val binding: InnerRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.innerRowText.text = item
        }
    }

}