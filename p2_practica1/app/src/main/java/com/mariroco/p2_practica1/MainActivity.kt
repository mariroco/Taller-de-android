package com.mariroco.p2_practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.mariroco.p2_practica1.core.presentation.BaseActivity
import com.mariroco.p2_practica1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun layoutId() = R.layout.activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
    }

    override val fragmentContainer: FragmentContainerView
        get() = binding.fcv

    override fun setUpNavigation(navController: NavController) = NavigationUI.setupWithNavController(binding.bnvMain, navController)


    override fun showProgress(show: Boolean) {
        binding.progressView.isVisible=show
    }

}