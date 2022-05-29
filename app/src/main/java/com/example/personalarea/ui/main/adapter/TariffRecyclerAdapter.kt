package com.example.personalarea.ui.main.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.R
import com.example.personalarea.data.model.Tariff
import java.util.Collections.addAll

class TariffRecyclerAdapter(
    private val tariffs: List<Tariff>,
) : RecyclerView.Adapter<TariffRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTariff: TextView = itemView.findViewById(R.id.textViewTariff)
        val textViewTariffSpeed: TextView = itemView.findViewById(R.id.textViewTariffSpeed)
        val costTextView: TextView = itemView.findViewById(R.id.tariffCost)
        val line: View = itemView.findViewById(R.id.line)

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
//        holder.textViewTariff.text = names[position]
//        holder.textViewTariffSpeed.text = speeds[position]
//        holder.costTextView.text = costs[position]
        holder.bind(tariffs[position])

        if (position == 0) {
            holder.line.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return tariffs.size
    }

    fun addTariffs(tariffs: List<Tariff>) {
        this.tariffs.apply {
            clear()
            addAll(tariffs)
        }
    }
}