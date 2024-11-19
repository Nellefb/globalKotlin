package com.example.ellenbarros_rm92899

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.TextView

   class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
       private val items = mutableListOf<ItemModel>()
       class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
           val textView = view.findViewById<TextView>(R.id.textViewItem)
           fun bind(item: ItemModel) {
               textView.text = item.titulo
               textView.text = item.descricao
           }
       }
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
           return ItemViewHolder(view)
       }
       override fun getItemCount(): Int = items.size
       override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
           val item = items[position]
           holder.bind(item)
       }
       fun addItem(newItem: ItemModel) {
           items.add(newItem)
           notifyDataSetChanged()
       }
   }
