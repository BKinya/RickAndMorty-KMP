package com.beatrice.swcast

import androidx.compose.ui.window.ComposeUIViewController
import com.beatrice.swcast.platform.initNapier
import com.beatrice.swcast.presentation.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController{
    initNapier()
    return ComposeUIViewController { App() }
}

