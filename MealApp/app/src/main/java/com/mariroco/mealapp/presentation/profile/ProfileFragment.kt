package com.mariroco.mealapp.presentation.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.databinding.ProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

class ProfileFragment : BaseFragment(R.layout.profile_fragment) {
    private lateinit var binding: ProfileFragmentBinding

    override fun setBinding(view: View) {
        binding = ProfileFragmentBinding.bind(view)
        binding.lifecycleOwner = this

        binding.txtNewAccount.setOnClickListener(){
            binding.loginContainer.isVisible = false
            binding.newAccountContainer.isVisible = true
        }

        binding.txtLoginExisting.setOnClickListener(){
            binding.loginContainer.isVisible = true
            binding.newAccountContainer.isVisible = false
        }

    }

}