package com.example.shoeinventorymanagement.ui.shoes.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeinventorymanagement.R
import com.example.shoeinventorymanagement.data.Shoe

class ShoeListAdapter : ListAdapter<Shoe, ShoeListAdapter.ShoeViewHolder>(ShoeComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        return ShoeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(
            current.id,
            current.brand,
            current.type,
            current.price
        )
    }

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shoeItemID : TextView = itemView.findViewById(R.id.textView_id)
        private val shoeItemBrand : TextView = itemView.findViewById(R.id.textView_brand)
        private val shoeItemType : TextView = itemView.findViewById(R.id.textView_type)
        private val shoeItemPrice : TextView = itemView.findViewById(R.id.textView_price)

        fun bind(
            id: String?,
            brand: String?,
            type: String?,
            price: Int?
        ) {
            shoeItemID.text = id
            shoeItemBrand.text = brand
            shoeItemType.text = type
            shoeItemPrice.text = "$${price.toString()}"
        }

        companion object {
            fun create(parent: ViewGroup) : ShoeViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shoe_list, parent, false)
                return ShoeViewHolder(view)
            }
        }
    }

    class ShoeComparator : DiffUtil.ItemCallback<Shoe>() {
        override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem.id == newItem.id
        }
    }
}