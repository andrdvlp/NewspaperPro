package com.example.newspaper.view.rv_adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.R
import com.example.newspaper.view.rv_viewholders.CategoryViewHolder

class CategoryRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<String>()
    private var category : String
    init {
        category = "General"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryViewHolder -> {
                if (items[position] == category) {
                    holder.category.setTextColor(Color.DKGRAY)
                    holder.bind(items[position])
                    holder.itemView.setOnClickListener {
                        clickListener.click(items[position])
                    }
                } else {
                    holder.category.textScaleX = 1F
                    holder.category.setTextColor(Color.LTGRAY)
                    holder.bind(items[position])
                    holder.itemView.setOnClickListener {
                        clickListener.click(items[position])
                    }

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnItemClickListener {
        fun click(string: String)
    }
}