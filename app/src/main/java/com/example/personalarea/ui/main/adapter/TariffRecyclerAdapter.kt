package com.example.personalarea.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.R
import com.example.personalarea.data.model.Tariff

class TariffRecyclerAdapter : ListAdapter<Tariff, TariffRecyclerAdapter.MyViewHolder>(ItemCallBack()) {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTariff: TextView = itemView.findViewById(R.id.textViewTariff)
        val textViewTariffSpeed: TextView = itemView.findViewById(R.id.textViewTariffSpeed)
        val costTextView: TextView = itemView.findViewById(R.id.tariffCost)

        fun bind (tariff: Tariff) {
            textViewTariff.text = tariff.title
            textViewTariffSpeed.text = tariff.speed.toString()
            costTextView.text = tariff.cost.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.tariff_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
class ItemCallBack : DiffUtil.ItemCallback<Tariff>(){
    override fun areItemsTheSame(oldItem: Tariff, newItem: Tariff): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tariff, newItem: Tariff): Boolean {
        return oldItem == newItem
    }
}