package com.jose.bussinesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jose.bussinesscard.data.BussinessCard
import com.jose.bussinesscard.data.BussinessCardRepository

class MainViewModel(
    private val bussinessCardRepository: BussinessCardRepository
    ) : ViewModel() {

    fun insert(bussinessCard: BussinessCard) {
        bussinessCardRepository.insert(bussinessCard)
    }

    fun getAll(): LiveData<List<BussinessCard>> {
        return bussinessCardRepository.getAll()
    }
}

class MainViewModelFactory(
    private val repository: BussinessCardRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }


}