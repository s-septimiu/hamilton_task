package co.septimiu_dev.hamilton_task.ui.base

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity(),
    BaseFragment.Callback {

    lateinit var viewModel: VM
    private var _baseBinding: B? = null
    private val baseBinding get() = _baseBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        _baseBinding = null
    }

    private fun performDataBinding() {
        _baseBinding = DataBindingUtil.setContentView(this, getLayoutId())
        baseBinding.lifecycleOwner = this
        this.viewModel = if (!::viewModel.isInitialized) getViewModelClass() else viewModel
        (baseBinding.root as? ViewGroup)?.layoutTransition?.enableTransitionType(
            LayoutTransition.CHANGING
        )
    }

    fun getViewDataBinding(): B = baseBinding

    abstract fun getViewModelClass(): VM

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String?) {}
}