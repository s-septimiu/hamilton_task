package co.septimiu_dev.hamilton_task.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.septimiu_dev.hamilton_task.R
import co.septimiu_dev.hamilton_task.databinding.FragmentMainBinding
import co.septimiu_dev.hamilton_task.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    private val mainFragmentViewModel: MainFragmentViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()
        setupListeners()
    }

    private fun setupListeners() {
        binding.mainNextButton.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionNavigationMainToExchange()
            )
        }
    }

    override fun getViewModelClass(): MainFragmentViewModel = mainFragmentViewModel
    override fun getLayoutId(): Int = R.layout.fragment_main
}