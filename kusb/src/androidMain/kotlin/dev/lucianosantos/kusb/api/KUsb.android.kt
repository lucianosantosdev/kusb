package dev.lucianosantos.kusb.api

import android.content.Context
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import com.hoho.android.usbserial.driver.UsbSerialDriver
import com.hoho.android.usbserial.driver.UsbSerialPort
import com.hoho.android.usbserial.driver.UsbSerialProber
import java.io.IOError
import java.io.IOException

actual class KUsb constructor (
    private val context: Context,
) {
    private var manager: UsbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
    private var serial: UsbDeviceConnection? = null
    private var port: UsbSerialPort? = null

    actual fun listDevices() : List<DeviceInfo> {
        return listUsbSerialPort().map { port ->
            DeviceInfo(
                port = port.serial,
                manufacturerName = port.device.manufacturerName,
                productName = port.device.productName,
                serialNumber = port.device.serialNumber
            )
        }
    }

    private fun listUsbSerialPort() : List<UsbSerialPort> {
        val availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager)
        var ports = mutableListOf<UsbSerialPort>()
        availableDrivers.forEach { driver ->
            ports.addAll(driver.ports)
        }
        return ports
    }

    actual fun openDevice(deviceSettings: DeviceSettings): Boolean {
        val driver = listUsbSerialPort().find { it.serial == deviceSettings.port }
        driver?.let { port ->
            try {
                serial = manager.openDevice(port.device)
                port.open(serial)
                port.setParameters(
                    deviceSettings.baudRate.value,
                    deviceSettings.dataBits.toUsbSerialPort(),
                    deviceSettings.stopBits.toUsbSerialPort(),
                    deviceSettings.parity.toUsbSerialPort()
                )
                return true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return false
    }

    actual fun isOpen(): Boolean {
        return port?.isOpen ?: false
    }

    actual fun closeDevice() {
        port?.close()
    }

    actual fun write(data: ByteArray, timeoutMs: Long): Int {
        try {
            port?.write(data, timeoutMs.toInt())
            return data.size
        } catch (e: Exception) {
            e.printStackTrace()
            return 0;
        }
    }

    actual fun read(bytes: Int, timeoutMs: Long): ByteArray? {
        val buffer = ByteArray(bytes)
        try {
            port?.read(buffer, timeoutMs.toInt())
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return buffer
    }
}