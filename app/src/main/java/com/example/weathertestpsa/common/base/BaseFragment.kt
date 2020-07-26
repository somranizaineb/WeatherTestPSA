package com.example.weathertestpsa.common.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weathertestpsa.common.viewModel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by zaineb on 25/07/2020
 */
abstract class BaseFragment : Fragment() {

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FACTORY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let {
            BaseApplication.component(
                it
            )?.inject(this)
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL FRAGMENT EXTENTION
    ///////////////////////////////////////////////////////////////////////////
    /**
     *
     * This is viewmodel extension for fragment needed viewmodel provider.
     */
    inline fun <reified T : ViewModel> Fragment.viewModel(): T =
        ViewModelProvider(this, viewModelFactory).get(T::class.java)
}