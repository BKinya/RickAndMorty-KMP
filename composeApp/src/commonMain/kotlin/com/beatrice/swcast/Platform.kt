package com.beatrice.swcast

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform



