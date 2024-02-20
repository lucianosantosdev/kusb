package dev.lucianosantos.kusb.api

actual class KUsb actual constructor(deviceSettings: DeviceSettings) {
    actual fun openDevice(): Boolean {
        TODO("Not yet implemented")
    }

    actual fun closeDevice() {
    }

    actual fun write(data: ByteArray): Int {
        TODO("Not yet implemented")
    }

    actual fun read(bytes: Int): ByteArray {
        TODO("Not yet implemented")
    }

    actual fun readAll(): ByteArray {
        TODO("Not yet implemented")
    }
}