package com.mariroco.mealapp.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.extension.failure
import com.mariroco.mealapp.core.extension.observe
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.core.presentation.BaseViewState
import com.mariroco.mealapp.core.utils.LayoutType
import com.mariroco.mealapp.databinding.MealsFragmentBinding
import com.mariroco.mealapp.domain.model.Meal
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


class MealsFragment : BaseFragment(R.layout.meals_fragment) {
    private lateinit var binding: MealsFragmentBinding
    private lateinit var adapter: MealsAdapter

    private val mealViewModel by viewModels<MealsViewModel>()
    var newLayout = LayoutType.LINEAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMeals("")
    }

    private fun setMeals(name: String){
        mealViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetMealsByName(name)
        }
    }

    override fun setBinding(view: View) {
        binding = MealsFragmentBinding.bind(view)
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

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is MealsViewState.MealsReceived -> setUpAdapter(state.meals)
        }
    }


}