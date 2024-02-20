package dev.lucianosantos.kusb.api

expect class KUsb {
    fun listDevices(): List<DeviceInfo>
    fun openDevice(deviceSettings: DeviceSettings): Boolean
    fun isOpen(): Boolean
    fun closeDevice()
    fun write(data: ByteArray, timeoutMs: Long): Int
    fun read(bytes: Int, timeoutMs: Long): ByteArray?
}