package com.beatrice.rickmortycast

import android.app.Application
import com.beatrice.rickmortycast.di.initKoin
import com.beatrice.rickmortycast.platform.initNapier
import org.koin.android.ext.koin.androidContext

class RickMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initNapier()
        initKoin{
            androidContext(this@RickMortyApplication)
        }
    }
}