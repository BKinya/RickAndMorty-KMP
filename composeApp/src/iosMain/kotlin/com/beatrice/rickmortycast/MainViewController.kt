package com.beatrice.rickmortycast

import androidx.compose.ui.window.ComposeUIViewController
import com.beatrice.rickmortycast.platform.initNapier
import com.beatrice.rickmortycast.presentation.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController{
    initNapier()
    return ComposeUIViewController { App() }
}

