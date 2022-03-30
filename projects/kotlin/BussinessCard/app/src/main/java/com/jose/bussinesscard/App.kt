package com.jose.bussinesscard

import android.app.Application
import com.jose.bussinesscard.data.AppDatabase
import com.jose.bussinesscard.data.BussinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BussinessCardRepository(database.bussinessDao()) }
}