package com.mariroco.p2_practica1.presentation.detailCocktail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mariroco.p2_practica1.R
import com.mariroco.p2_practica1.core.presentation.BaseFragment
import com.mariroco.p2_practica1.databinding.CocktailDetailFragmentBinding

class CocktailDetailFragment : BaseFragment(R.layout.cocktail_detail_fragment) {
    // Clase autogenerada
    private lateinit var binding: CocktailDetailFragmentBinding
    override fun setBinding(view: View) {
        binding= CocktailDetailFragmentBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@CocktailDetailFragment
            //Al agregar CocktailDetailFragment al maingraph podemos
            //cocktail = requireArguments()
        }
    }


}