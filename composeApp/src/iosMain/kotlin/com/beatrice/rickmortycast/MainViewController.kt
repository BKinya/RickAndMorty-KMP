package com.beatrice.rickmortycast

import androidx.compose.ui.window.ComposeUIViewController
import com.beatrice.rickmortycast.di.initKoin
import com.beatrice.rickmortycast.platform.initNapier
import com.beatrice.rickmortycast.presentation.App
import platform.UIKit.UIViewController

fun MainViewController() = ComposeUIViewController(
    configure = {
        initNapier()
        initKoin()
    }
) { App() }



