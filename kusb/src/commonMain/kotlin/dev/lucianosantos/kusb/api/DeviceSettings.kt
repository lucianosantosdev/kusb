package dev.lucianosantos.kusb.api

data class DeviceSettings(
    val port: String,
    val baudRate: BaudRate,
    val dataBits: DataBits,
    val stopBits: StopBits,
    val parity: Parity
)
