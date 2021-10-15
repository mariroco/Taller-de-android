package com.mariroco.p2_practica1.presentation.cocktails

import android.annotation.SuppressLint
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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mariroco.p2_practica1.core.utils.LayoutType
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
    var newLayout = LayoutType.LINEAR


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
        binding.nodataView.isVisible = cocktails.isEmpty()
        adapter = CocktailAdapter()

        adapter.addData(cocktails)

        binding.rcCocktails.apply {
            isVisible = cocktails.isNotEmpty()
            adapter = this@CocktailFragment.adapter
        }

        adapter.viewChange(newLayout)
    }

    override fun setBinding(view: View) {
        binding = CocktailFragmentBinding.bind(view)

        binding.lifecycleOwner = this

        binding.svCocktail.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if(p0!==null)
                    setCocktails(p0)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0!==null)
                    setCocktails(p0)
                return true
            }
        })

        binding.fabViewChange.setOnClickListener{
             newLayout = if(adapter.layoutType == LayoutType.LINEAR){
                binding.rcCocktails.layoutManager = GridLayoutManager(requireContext(),3)
                LayoutType.GRID
            }
            else{
                binding.rcCocktails.layoutManager = LinearLayoutManager(requireContext())
                LayoutType.LINEAR
            }
            adapter.viewChange(newLayout)
        }
    }




}