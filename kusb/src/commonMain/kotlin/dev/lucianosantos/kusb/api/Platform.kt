package dev.lucianosantos.kusb.api

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform