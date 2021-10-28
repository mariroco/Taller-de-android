package com.mariroco.mealapp.presentation.meals

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mariroco.mealapp.core.utils.LayoutType
import com.mariroco.mealapp.databinding.GridMealBinding
import com.mariroco.mealapp.databinding.RowMealBinding
import com.mariroco.mealapp.domain.model.Meal

@SuppressLint("NotifyDataSetChanged")
class MealsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context : Context
    private var list: MutableList<Meal> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    lateinit var listener : (meal: Meal) -> Unit

    fun addData(list: List<Meal>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setContext(context: Context){
        this.context = context
    }

    fun filterData(filter: String) : MutableList<Meal>{
        var filtered:MutableList<Meal> = mutableListOf()
        list.forEach{
            if(it.category.equals(filter)){
                filtered.add(it) }
        }
        return filtered
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
            RowMealBinding.inflate(LayoutInflater.from(parent.context),parent,false),context
        )
        else-> ViewHolderGridItem(
            GridMealBinding.inflate(LayoutInflater.from(parent.context),parent,false),context
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).bind(
            list[position], listener
        )
    }

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowMealBinding, context: Context) :
        BaseViewHolder(binding.root){
        private var context = context

        override fun bind(data: Meal, listener: (meal: Meal) -> Unit) {
            binding.meal = data
            binding.imgFav.setOnClickListener{
                Toast.makeText(context, "fav", Toast.LENGTH_SHORT).show()
            }
            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }

    class ViewHolderGridItem(private val binding: GridMealBinding,context: Context) :
        BaseViewHolder(binding.root){
        private var context = context

        override fun bind(data: Meal, listener: (meal: Meal) -> Unit) {
            binding.meal = data
            binding.imgFav.setOnClickListener{
                Toast.makeText(context, "fav", Toast.LENGTH_SHORT).show()
            }
            binding.root.setOnClickListener{
                listener(data)
            }
        }
    }

}

abstract class BaseViewHolder(private val root: View): RecyclerView.ViewHolder(root){
    abstract fun bind(data: Meal, listener: (meal: Meal) -> Unit)
}