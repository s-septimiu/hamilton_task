package co.septimiu_dev.hamilton_task.ui.confirmation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.septimiu_dev.hamilton_task.R
import co.septimiu_dev.hamilton_task.databinding.FragmentConfirmationBinding
import co.septimiu_dev.hamilton_task.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmationFragment : BaseFragment<FragmentConfirmationBinding, ConfirmationViewModel>() {

    private val confirmationFragmentViewModel: ConfirmationViewModel by viewModels()
    private lateinit var binding: FragmentConfirmationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()
        setupListeners()
    }

    private fun setupListeners() {
        binding.confirmationNextButton.setOnClickListener {
            findNavController().navigate(
                ConfirmationFragmentDirections.actionNavigationConfirmationToMain()
            )
        }
    }

    override fun getViewModelClass(): ConfirmationViewModel = confirmationFragmentViewModel
    override fun getLayoutId(): Int = R.layout.fragment_confirmation
}