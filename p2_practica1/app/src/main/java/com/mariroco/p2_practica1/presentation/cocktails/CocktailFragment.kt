package com.mariroco.p2_practica1.presentation.cocktails

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mariroco.p2_practica1.R
import com.mariroco.p2_practica1.core.extension.failure
import com.mariroco.p2_practica1.core.extension.observe
import com.mariroco.p2_practica1.core.presentation.BaseFragment
import com.mariroco.p2_practica1.core.presentation.BaseViewState
import com.mariroco.p2_practica1.databinding.CocktailFragmentBinding
import com.mariroco.p2_practica1.domain.model.Cocktail
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class CocktailFragment : BaseFragment(R.layout.cocktail_fragment) {

    private lateinit var binding: CocktailFragmentBinding

    private lateinit var adapter: CocktailAdapter
    private val cocktailViewModel by viewModels<CocktailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Conecta con el viewmodel y obtiene lista de cocteles
        setCocktails("")


    }

    private fun  setCocktails(name: String){
        cocktailViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            doGetCocktailsByName(name)

        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is CocktailViewState.CocktailsReceived -> setUpAdapter(state.cocktails)
        }
    }



    private fun setUpAdapter(cocktails: List<Cocktail>) {
        adapter = CocktailAdapter()

        adapter.addData(cocktails)

        binding.rcCocktails.apply {
            adapter = this@CocktailFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = CocktailFragmentBinding.bind(view)

        binding.lifecycleOwner = this

        
    }



}