package co.septimiu_dev.hamilton_task.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import co.septimiu_dev.hamilton_task.R
import co.septimiu_dev.hamilton_task.databinding.ActivityMainBinding
import co.septimiu_dev.hamilton_task.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    private val viewModelMain: MainActivityViewModel by viewModels()
    private lateinit var homeBinding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        homeBinding = getViewDataBinding()
        getNavController()
    }

    private fun getNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun getViewModelClass(): MainActivityViewModel = viewModelMain
    override fun getLayoutId(): Int = R.layout.activity_main
}