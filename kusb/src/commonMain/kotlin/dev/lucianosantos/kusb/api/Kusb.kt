package dev.lucianosantos.kusb.api

class Kusb {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}