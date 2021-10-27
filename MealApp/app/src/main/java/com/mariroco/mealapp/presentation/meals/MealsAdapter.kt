package com.mariroco.mealapp.presentation.meals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariroco.mealapp.core.utils.LayoutType
import com.mariroco.mealapp.databinding.GridMealBinding
import com.mariroco.mealapp.databinding.RowMealBinding
import com.mariroco.mealapp.domain.model.Meal

@SuppressLint("NotifyDataSetChanged")
class MealsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var list: MutableList<Meal> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    lateinit var listener : (meal: Meal) -> Unit

    fun addData(list: List<Meal>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun getData() : List<Meal>{
        return list
    }

    fun viewChange(layoutType: LayoutType){
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType){
        LayoutType.LINEAR.ordinal ->  ViewHolderItem(
            RowMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
        else-> ViewHolderGridItem(
            GridMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).bind(
            list[position], listener
        )
    }

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowMealBinding) :
        BaseViewHolder(binding.root){

        override fun bind(data: Meal, listener: (meal: Meal) -> Unit) {
            binding.meal = data

            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }

    class ViewHolderGridItem(private val binding: GridMealBinding) :
        BaseViewHolder(binding.root){

        override fun bind(data: Meal, listener: (meal: Meal) -> Unit) {
            binding.meal = data
            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }

}

abstract class BaseViewHolder(private val root: View): RecyclerView.ViewHolder(root){
    abstract fun bind(data: Meal, listener: (meal: Meal) -> Unit)
}