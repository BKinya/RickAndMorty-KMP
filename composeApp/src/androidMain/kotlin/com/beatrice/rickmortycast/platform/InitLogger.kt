package com.beatrice.rickmortycast.platform

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual fun initNapier(){
    Napier.base(DebugAntilog())
}