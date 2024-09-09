package com.beatrice.swcast

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
