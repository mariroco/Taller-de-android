package com.mariroco.p2_practica1.core.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController

abstract class BaseActivity: AppCompatActivity() {
    abstract fun layoutId():Int
    abstract val fragmentContainer : FragmentContainerView

    abstract fun setUpNavigation(navController: NavController)
    abstract fun showProgress(show:Boolean)
    abstract fun setBinding()
}