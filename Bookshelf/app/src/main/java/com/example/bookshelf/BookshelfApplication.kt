package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.ui.data.AppContainer
import com.example.bookshelf.ui.data.DefaultAppContainer

class BookshelfApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}