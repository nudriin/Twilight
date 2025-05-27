package com.nudriin.someproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.nudriin.someproject.R
import com.nudriin.someproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
    }

    private fun setupAction() {
        with(binding) {
            btnMenu.setOnClickListener {
                navigateToMenuList()
            }

            btnDescription.setOnClickListener {
                navigateToDescription()
            }

            btnExit.setOnClickListener {
                requireActivity().finishAffinity()
            }

            topAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu1 -> {
                        requireActivity().finishAffinity()
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun navigateToMenuList() {
        val toMenuList = HomeFragmentDirections.actionHomeFragmentToDetailProductFragment()
        Navigation.findNavController(binding.root).navigate(toMenuList)
    }

    private fun navigateToDescription() {
        val toDescription = HomeFragmentDirections.actionHomeFragmentToDescriptionFragment()
        Navigation.findNavController(binding.root).navigate(toDescription)
    }
}