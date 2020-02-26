package com.example.motionlayoutsandbox.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsandbox.R

class StartPageAdapter(val mData: List<Pair<String, () -> Unit>>) :
    RecyclerView.Adapter<StartPageAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_startpage, parent, false)
        )

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val model = mData[position]
        holder.bind(model.first)
        holder.itemView.setOnClickListener { model.second.invoke() }
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(model: String) {
            (itemView as TextView).text = model
        }
    }
}