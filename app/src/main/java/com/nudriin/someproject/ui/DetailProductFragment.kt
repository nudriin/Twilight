package com.nudriin.someproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nudriin.someproject.R
import com.nudriin.someproject.adapter.UserAdapter
import com.nudriin.someproject.data.UserData
import com.nudriin.someproject.databinding.FragmentDetailProductBinding

class DetailProductFragment : Fragment() {
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        val data = listOf<UserData>(
            UserData("Ragil", "ragil@gmail.com", "088128384"),
            UserData("Nurdin", "nudriin@gmail.com", "08812384"),
            UserData("FyodoR", "fyodoR@gmail.com", "088128384"),
            UserData("Rosemary", "rM@gmail.com", "088128384"),
            UserData("Ouros", "boros@gmail.com", "088128384"),
        )

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvCardList.layoutManager = layoutManager
        setUserData(data)
    }

    private fun setUserData(data: List<UserData>) {
        val adapter = UserAdapter(data)
        binding.rvCardList.adapter = adapter
    }
}