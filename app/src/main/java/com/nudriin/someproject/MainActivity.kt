package com.nudriin.someproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nudriin.someproject.adapter.UserAdapter
import com.nudriin.someproject.data.UserData
import com.nudriin.someproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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

        val layoutManager = LinearLayoutManager(this)
        binding.rvCardList.layoutManager = layoutManager
        setUserData(data)
    }

    private fun setUserData(data: List<UserData>) {
        val adapter = UserAdapter(data)
        binding.rvCardList.adapter = adapter
    }
}