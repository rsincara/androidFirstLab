package com.example.personalarea.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.R
import com.example.personalarea.data.model.UserInfo

class UserRecyclerAdapter :
    ListAdapter<UserInfo, UserRecyclerAdapter.MyViewHolder>(UserInfoCallBack()) {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userInfoIcon: ImageView = itemView.findViewById(R.id.userInfoIcon)
        val userInfoText: TextView = itemView.findViewById(R.id.userInfoText)

        fun bind(userInfo: UserInfo) {
            userInfoIcon.setImageResource(userInfo.icon ?: R.drawable.user)
            userInfoText.text = userInfo.firstName + " " + userInfo.lastName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.user_info_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class UserInfoCallBack : DiffUtil.ItemCallback<UserInfo>() {
    override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
        return oldItem == newItem
    }
}