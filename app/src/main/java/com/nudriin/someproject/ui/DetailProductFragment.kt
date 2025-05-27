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
            UserData(
                "Nike Pegasus 41 \"Jakob Ingebrigtsen\"",
                "Men's Road Running Shoes",
                "Rp 2,199,000",
                R.drawable.pegasus
            ),
            UserData(
                "A'One 'OG Pearls' EP",
                "A'ja Wilson Basketball Shoes",
                "Rp 1,729,000",
                R.drawable.aone_og_pearls_ep
            ),
            UserData(
                "A'One 'OG Pearl'",
                "A'ja Wilson Older Kids' Basketball Shoes",
                "Rp 1,429,000",
                R.drawable.aone_og_pearl
            ),
            UserData(
                "Nike Zoom Rival Fly 4", "Men's Road Racing Shoes", "Rp 1,549,000",
                R.drawable.zoom_rival
            ),
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