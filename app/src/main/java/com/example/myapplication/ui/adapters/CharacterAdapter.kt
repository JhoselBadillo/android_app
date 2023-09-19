package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.network.model.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(private var characterList: List< Character>) :
        RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val character = characterList[position]
        holder.nameTextView.text = character.name

        Picasso.get()
            .load(character.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    fun updateCharacterList(newList: List<Character>){
        characterList = newList
        notifyDataSetChanged()
    }
        }