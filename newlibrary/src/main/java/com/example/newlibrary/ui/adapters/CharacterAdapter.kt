package com.example.newlibrary.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.characterdetails.Details
import com.example.newlibrary.R
import com.squareup.picasso.Picasso



class CharacterAdapter(private var characterList: List<com.example.newlibrary.ui.models.UICharacter>) :
        RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.nameTextView.text = character.name

        Picasso.get()
            .load(character.imageUrl)
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()


            val newDetailsFragment = Details.newInstance(character.name, character.imageUrl)
            fragmentTransaction.replace(R.id.homeFragment, newDetailsFragment)

            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.tvCharacter)
        val imageView: ImageView = itemView.findViewById(R.id.ivCharacter)
    }

    fun updateCharacterList(newList: List<com.example.newlibrary.ui.models.UICharacter>){
        characterList = newList
        notifyDataSetChanged()
    }
        }