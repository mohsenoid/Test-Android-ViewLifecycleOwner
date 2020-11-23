package com.mohsenoid.myapplication.ui.sub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mohsenoid.myapplication.databinding.SubFragmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber

class SubFragment : Fragment() {

    private var _binding: SubFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SubViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SubViewModel::class.java)

        _binding = SubFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = ViewModelProvider(this).get(SubViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            while (isActive) {
                Timber.d("Tick C!")
                viewModel.c.value = !viewModel.c.value!!
                delay(1000)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            while (isActive) {
                Timber.d("Tick D!")
                viewModel.d.value = !viewModel.d.value!!
                delay(1000)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
