package com.example.motionlayoutsandbox.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsandbox.R

class DefAdapter : RecyclerView.Adapter<DefAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_startpage, parent, false)
        )
    }

    override fun getItemCount() = 20

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind()
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            with(itemView as TextView) {
                text = "Item $adapterPosition"
            }
        }
    }
}