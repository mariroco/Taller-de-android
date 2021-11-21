package com.mariroco.mealapp.presentation.randomMeals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.extension.failure
import com.mariroco.mealapp.core.extension.observe
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.core.presentation.BaseViewState
import com.mariroco.mealapp.databinding.MealDetailFragmentBinding
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.presentation.mealDetail.MealDetailFragmentArgs
import com.mariroco.mealapp.presentation.meals.MealsViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class RandomFragment : BaseFragment(R.layout.meal_detail_fragment) {

    private lateinit var binding: MealDetailFragmentBinding
    private val randomViewModel by viewModels<RandomViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMeal()
    }

    override fun setBinding(view: View) {
        binding = MealDetailFragmentBinding.bind(view)
        binding.lifecycleOwner = this
        binding.apply {
            item = Meal()
        }
    }

    private fun setMeal(){
        //se aplican cambios al viewmodel
        randomViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetRandomMeal(true)
        }
    }

    private fun setUpAdapter(meal: Meal){
        binding.apply {
            item = meal
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is MealsViewState.MealsReceived -> setUpAdapter(state.meals[0])
        }
    }

}