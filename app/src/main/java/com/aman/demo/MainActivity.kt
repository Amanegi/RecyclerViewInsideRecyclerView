package com.aman.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.demo.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = MainRecyclerAdapter(this, fetchJSON())
    }

    private fun fetchJSON(): JSONObject {
        // object 1
        val arr1 = JSONArray()
        arr1.put("Dal makhni")
        arr1.put("Pulao")
        arr1.put("Paneer bhurji")
        arr1.put("Roti")
        arr1.put("Naan")
        val obj1 = JSONObject()
        obj1.put(NAME, "KFC")
        obj1.put(ITEMS, arr1)
        // object 2
        val arr2 = JSONArray()
        arr2.put("Shahi chicken")
        arr2.put("Bakra kabab")
        arr2.put("Fish curry")
        arr2.put("Parantha")
        val obj2 = JSONObject()
        obj2.put(NAME, "Shudh Non Veg")
        obj2.put(ITEMS, arr2)
        // object 3
        val arr3 = JSONArray()
        arr3.put("Anda curry")
        arr3.put("Anda bhurji")
        arr3.put("Shahi anda")
        arr3.put("Anda parantha")
        arr3.put("Roti")
        val obj3 = JSONObject()
        obj3.put(NAME, "Egg Nation")
        obj3.put(ITEMS, arr3)
        // object 4
        val arr4 = JSONArray()
        arr4.put("Aloo parantha")
        arr4.put("Gobi parantha")
        arr4.put("Muli parantha")
        arr4.put("Onion parantha")
        arr4.put("Palak parantha")
        arr4.put("Paneer parantha")
        val obj4 = JSONObject()
        obj4.put(NAME, "Paranthe hi paranthe")
        obj4.put(ITEMS, arr4)

        val jsonArray = JSONArray()
        jsonArray.put(obj1)
        jsonArray.put(obj2)
        jsonArray.put(obj3)
        jsonArray.put(obj4)

        val jsonObject = JSONObject()
        jsonObject.put(DATA, jsonArray)

        return jsonObject
    }

}
