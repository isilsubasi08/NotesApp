package com.isilsubasi.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isilsubasi.myapplication.databinding.AvatarItemBinding

class AvatarAdapter(var avatarList : List<AvatarModel>,
                    var onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<AvatarAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : AvatarItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=AvatarItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder){
            binding.apply {
                imageAvatar.setImageResource(avatarList[position].imageSrc)
            }
        }
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }

    }

    override fun getItemCount(): Int {
        return  avatarList.size
    }
}