package com.example.eletriccarapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.data.local.CarRepository
import com.example.eletriccarapp.domain.Carro
import com.example.eletriccarapp.ui.adpter.CarAdapter

class FavoriteFragment: Fragment() {

    lateinit var lista: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupList()

    }

    override fun onResume() {
        super.onResume()
        setupList()

    }

    fun setupView(view: View) {
        view.apply {
            lista = findViewById(R.id.lv_informacoes_favoritos)
        }
    }
    fun setupList() {
        val repository = CarRepository(requireContext())
        val carList = repository.getAll()
        val carroAdapter = CarAdapter(carList, isFavoriteScreen = true)
        lista.apply {
            isVisible  = true
            adapter     = carroAdapter
        }

        carroAdapter.carItemLister = { carro ->
            val delete = CarRepository(requireContext()).deleteIfExists(carro)
            setupList()
        }
    }


}