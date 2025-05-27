package com.nudriin.someproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nudriin.someproject.data.UserData
import com.nudriin.someproject.databinding.CardUserBinding

class UserAdapter(private val cardList: List<UserData>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card)
    }

    class ViewHolder(private val binding: CardUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UserData) {
            with(binding) {
                tvName.text = data.name
                tvEmail.text = data.email
                tvPhone.text = data.phone
                ivArticleHomeThumbnail.setImageResource(data.imgId)
            }
        }
    }

}