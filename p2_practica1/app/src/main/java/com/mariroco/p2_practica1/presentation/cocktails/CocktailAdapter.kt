package com.mariroco.p2_practica1.presentation.cocktails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariroco.p2_practica1.core.utils.LayoutType
import com.mariroco.p2_practica1.databinding.GridCocktailBinding
import com.mariroco.p2_practica1.databinding.RowCocktailBinding
import com.mariroco.p2_practica1.domain.model.Cocktail

/*
// * * *
interface  Listener {
    fun onClickRow(data: Cocktail)
}*/

@SuppressLint("NotifyDataSetChanged")
class CocktailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Cocktail> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    // * * * Esta declaración sirve cuando tenemos varios métodos diferentes, sin embargo no es conveniente en este caso porque solo tenermos 1 método
    //lateinit var listener: Listener

    //Almacenamos la función directamente en la variable
    lateinit var listener: (cocktail: Cocktail) -> Unit

    fun addData(list: List<Cocktail>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun viewChange(layoutType: LayoutType){
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType){
        LayoutType.LINEAR.ordinal -> ViewHolderItem(
            RowCocktailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
        else -> ViewHolderGridItem(
            GridCocktailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowCocktailBinding) :
        BaseViewHolder(binding.root){

        override fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit) {
            //Hace un binding entre la data y la variable del rowcocktail
            binding.item = data

            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }

    class ViewHolderGridItem(private val binding: GridCocktailBinding) :
        BaseViewHolder(binding.root){

        override fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit) {
            //Hace un binding entre la data y la variable del gridcocktail
            binding.item = data
            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }
}

//creamos clase abstracta para los holders
abstract class BaseViewHolder(private val root: View):RecyclerView.ViewHolder(root){
    abstract fun bind(data: Cocktail, listener: (cocktail: Cocktail) -> Unit)
}