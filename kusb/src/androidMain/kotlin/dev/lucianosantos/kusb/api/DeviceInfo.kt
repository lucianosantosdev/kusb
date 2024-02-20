package dev.lucianosantos.kusb.api

data class DeviceInfo(
    val port: String,
    val manufacturerName: String?,
    val productName: String?,
    val serialNumber: String?,
)
