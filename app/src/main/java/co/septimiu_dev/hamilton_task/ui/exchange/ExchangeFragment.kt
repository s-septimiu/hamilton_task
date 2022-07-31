package co.septimiu_dev.hamilton_task.ui.exchange

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.septimiu_dev.hamilton_task.BR
import co.septimiu_dev.hamilton_task.R
import co.septimiu_dev.hamilton_task.databinding.FragmentExchangeBinding
import co.septimiu_dev.hamilton_task.ui.base.BaseFragment
import co.septimiu_dev.hamilton_task.ui.main.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangeFragment : BaseFragment<FragmentExchangeBinding, ExchangeViewModel>() {

    private val exchangeFragmentViewModel: ExchangeViewModel by viewModels()
    private lateinit var binding: FragmentExchangeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()
        setupListeners()
    }

    private fun setupListeners() {
        binding.exchangeNextButton.setOnClickListener {
            findNavController().navigate(
                ExchangeFragmentDirections.actionNavigationExchangeToConfirmation()
            )
        }
    }

    override fun getViewModelClass(): ExchangeViewModel = exchangeFragmentViewModel
    override fun getLayoutId(): Int = R.layout.fragment_exchange
}