package com.beatrice.rickmortycast

import android.app.Application
import com.beatrice.rickmortycast.platform.initNapier

class RickMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initNapier()
    }
}