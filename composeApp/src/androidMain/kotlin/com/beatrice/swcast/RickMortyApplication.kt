package com.beatrice.swcast

import android.app.Application
import com.beatrice.swcast.platform.initNapier

class RickMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initNapier()
    }
}