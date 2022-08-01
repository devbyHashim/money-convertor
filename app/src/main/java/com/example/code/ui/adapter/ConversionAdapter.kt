package com.example.code.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.code.databinding.ItemConversionsBinding
import kotlin.properties.Delegates

class ConversionAdapter(
    private val context: Context
) : RecyclerView.Adapter<ConversionAdapter.ItemViewHolder>() {

    private var itemList: List<String> by Delegates.observable(emptyList()) { _, _, _ ->

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val itemBinding =
            ItemConversionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

      //  holder.bind(itemList[position])
    }

    override fun getItemCount() = 10

    fun updateData(items: List<String>) {
        itemList = items
    }

    class ItemViewHolder(private val itemBinding: ItemConversionsBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(string: String) {
            itemBinding.tvTitle.text = string
            itemBinding.tvRate.text = string
        }
    }
}