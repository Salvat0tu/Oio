package com.example.oio

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.oio.databinding.ItemBinding

class PersoneAdapter(val personeList: List<Persone>): RecyclerView.Adapter<PersoneAdapter.PersoneViewHolder>() {
    class PersoneViewHolder(val binding:ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersoneViewHolder {
        return PersoneViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return personeList.size
    }

    override fun onBindViewHolder(holder: PersoneViewHolder, position: Int) {
        val model = personeList[position]
        holder.binding.itemText.text = model.nome
        holder.binding.itemImage.setImageResource(model.immagine)
        holder.binding.itemImage.setOnClickListener {
            holder.binding.itemImage.animate().apply {
                duration = 500
                rotationBy(180f)
            }
        }
    }

}