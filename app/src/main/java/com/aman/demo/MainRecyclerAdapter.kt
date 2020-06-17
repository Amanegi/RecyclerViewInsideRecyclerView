package com.aman.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aman.demo.databinding.RowLayoutBinding
import org.json.JSONObject

class MainRecyclerAdapter(val context: Context, private val jsonObject: JSONObject) :
    RecyclerView.Adapter<MainRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = jsonObject.getJSONArray(DATA).length()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = jsonObject.getJSONArray(DATA)
        holder.bind(data.getJSONObject(position))
    }

    inner class MyViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(json: JSONObject) {
            binding.rowCountryName.text = json.getString(NAME)
            binding.rowRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.rowRecyclerView.adapter = InnerRecyclerAdapter(json.getJSONArray(ITEMS))
        }
    }
}
