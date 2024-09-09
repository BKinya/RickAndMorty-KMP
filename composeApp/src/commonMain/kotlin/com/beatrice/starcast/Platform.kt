package com.beatrice.starcast

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
