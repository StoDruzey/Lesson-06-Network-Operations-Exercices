package com.example.lesson06networkoperationsexercices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson06networkoperationsexercices.databinding.ActivityMainBinding
import com.example.lesson06networkoperationsexercices.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val items = mutableListOf<String>()
        val adapter = ItemAdapter(items)

        with(binding) {

            button.setOnClickListener {
                items.add("Item ${items.size}")
                adapter.notifyDataSetChanged()
            }
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }
    }
}

class ItemViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.textView.text = item
    }
}

class ItemAdapter(private val list: List<String>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}