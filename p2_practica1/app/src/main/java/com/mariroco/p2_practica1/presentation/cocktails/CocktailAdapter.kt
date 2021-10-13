package com.mariroco.p2_practica1.presentation.cocktails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariroco.p2_practica1.databinding.RowCocktailBinding
import com.mariroco.p2_practica1.domain.model.Cocktail

class CocktailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Cocktail> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: List<Cocktail>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowCocktailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolderItem).bind(
            list[position]
        )

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowCocktailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Cocktail) {
            //Hace un binding entre la data y la variable del rococktail
            binding.item = data
        }
    }

}