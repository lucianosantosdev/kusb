package dev.lucianosantos.kusb.api

expect class KUsb(
    deviceSettings: DeviceSettings
){
    fun openDevice(): Boolean
    fun closeDevice()
    fun write(data: ByteArray): Int
    fun read(bytes: Int): ByteArray
    fun readAll(): ByteArray
}