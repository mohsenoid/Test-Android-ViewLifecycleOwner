package com.mohsenoid.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.mohsenoid.myapplication.R
import com.mohsenoid.myapplication.databinding.MainFragmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber

class MainFragment : Fragment(), MainViewModel.Callback {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.callback = this@MainFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            while (isActive) {
                Timber.d("Tick A!")
                viewModel.a.value = !viewModel.a.value!!
                delay(1000)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            while (isActive) {
                Timber.d("Tick B!")
                viewModel.b.value = !viewModel.b.value!!
                delay(1000)
            }
        }
    }

    override fun onNextClick() {
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_subFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
