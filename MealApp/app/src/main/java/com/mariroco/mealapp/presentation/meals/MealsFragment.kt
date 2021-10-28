package com.mariroco.mealapp.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.extension.failure
import com.mariroco.mealapp.core.extension.observe
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.core.presentation.BaseViewState
import com.mariroco.mealapp.core.utils.LayoutType
import com.mariroco.mealapp.databinding.MealsFragmentBinding
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.Meal
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class MealsFragment : BaseFragment(R.layout.meals_fragment), AdapterView.OnItemClickListener {
    private lateinit var binding: MealsFragmentBinding
    private var adapter: MealsAdapter= MealsAdapter()
    private var filteredAdapter: MealsAdapter= MealsAdapter()

    private val mealsViewModel by viewModels<MealsViewModel>()
    var newLayout = LayoutType.LINEAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMeals("")
        setCategories()
    }

    private fun setMeals(name: String){
        mealsViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetMealsByName(name)
        }
    }

    override fun setBinding(view: View) {
        binding = MealsFragmentBinding.bind(view)
        binding.lifecycleOwner = this
        binding.svMeal.setOnQueryTextListener(object  : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0!==null) {
                    setMeals(p0)
                    setCategories()
                    binding.txtFilter.setSelection(0)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0!==null){
                    setMeals(p0)
                    setCategories()
                    binding.txtFilter.setSelection(0)
                }
                return true

            }
        })



        binding.fabViewChange.setOnClickListener{
            newLayout = if(adapter.layoutType == LayoutType.LINEAR){
                binding.rcMeals.layoutManager = GridLayoutManager(requireContext(),3)
                LayoutType.GRID
            }else{
                binding.rcMeals.layoutManager = LinearLayoutManager(requireContext())
                LayoutType.LINEAR
            }
            adapter.viewChange(newLayout)
        }

        binding.txtFilter.onItemClickListener = this@MealsFragment
    }

    private fun setUpAdapter(meals: List<Meal>){
        binding.nodataView.isVisible = meals.isEmpty()
        adapter = MealsAdapter()

        adapter.addData(meals)
        adapter.listener = {
            navController.navigate(MealsFragmentDirections.actionMealsFragmentToMealDetailFragment(it))
        }

        adapter.addData(meals)
        binding.rcMeals.apply {
            isVisible = meals.isNotEmpty()
            adapter = this@MealsFragment.adapter
        }
        adapter.viewChange(newLayout)
    }

    private fun setCategories(){
        mealsViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetCategoriesByName(true)
        }
    }

    private fun setUpCategoriesAdapter(categoriesList: List<Category>){
        var categories: MutableList<String> = arrayListOf()
        var i=0
        categories.add(getResources().getString(R.string.category))

        while(i< categoriesList.size){
            categories.add(categoriesList[i].name)
            i++
        }

        var categoryAdapter = ArrayAdapter<String>(
            this.requireContext(),
            R.layout.list_item,
            categories)

        binding.txtFilter.setAdapter(categoryAdapter)
        //binding.txtFilter.setSelection(categoryAdapter.getPosition(getResources().getString(R.string.category)))
        binding.txtFilter.setSelection(0)
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is MealsViewState.MealsReceived -> setUpAdapter(state.meals)
            is MealsViewState.CategoriesReceived -> setUpCategoriesAdapter(state.categories)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        val filteredMeals: MutableList<Meal> = adapter.filterData(item)
        if(item.equals(getResources().getString(R.string.category)) || item.isEmpty() || item.equals(" ")){
            setMeals("")
            setCategories()
        }else {
            binding.nodataView.isVisible = filteredMeals.isEmpty()
            filteredAdapter = MealsAdapter()
            filteredAdapter.addData(filteredMeals)
            filteredAdapter.listener = {
                navController.navigate(
                    MealsFragmentDirections.actionMealsFragmentToMealDetailFragment(
                        it
                    )
                )
            }

            filteredAdapter.addData(filteredMeals)
            binding.rcMeals.apply {
                isVisible = filteredMeals.isNotEmpty()
                adapter = this@MealsFragment.filteredAdapter
            }
            filteredAdapter.viewChange(newLayout)
        }
    }


}