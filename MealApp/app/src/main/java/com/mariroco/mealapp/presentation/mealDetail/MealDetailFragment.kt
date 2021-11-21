package com.mariroco.mealapp.presentation.mealDetail

import android.view.View
import androidx.navigation.fragment.navArgs
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.databinding.MealDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class MealDetailFragment : BaseFragment(R.layout.meal_detail_fragment) {
    private lateinit var binding: MealDetailFragmentBinding
    private val args: MealDetailFragmentArgs by navArgs()
    override fun setBinding(view: View) {
        binding = MealDetailFragmentBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@MealDetailFragment
            item = args.meal
        }
    }


}