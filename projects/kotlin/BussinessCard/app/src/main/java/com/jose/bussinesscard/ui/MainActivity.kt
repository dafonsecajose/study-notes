package com.jose.bussinesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import com.jose.bussinesscard.App
import com.jose.bussinesscard.databinding.ActivityMainBinding
import com.jose.bussinesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BussinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCards.adapter = adapter

        getAllBussinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBussinessCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listernerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllBussinessCard() {
        mainViewModel.getAll().observe(this) {
            adapter.submitList(it)
        }
    }
}