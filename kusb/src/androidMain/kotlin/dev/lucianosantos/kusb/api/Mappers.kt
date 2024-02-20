package dev.lucianosantos.kusb.api

import com.hoho.android.usbserial.driver.UsbSerialPort

internal fun DataBits.toUsbSerialPort(): Int {
    return when (this) {
        DataBits.DATA_BITS_5 -> UsbSerialPort.DATABITS_5
        DataBits.DATA_BITS_6 -> UsbSerialPort.DATABITS_6
        DataBits.DATA_BITS_7 -> UsbSerialPort.DATABITS_7
        DataBits.DATA_BITS_8 -> UsbSerialPort.DATABITS_8
    }
}

internal fun StopBits.toUsbSerialPort(): Int {
    return when (this) {
        StopBits.STOP_BITS_1 -> UsbSerialPort.STOPBITS_1
        StopBits.STOP_BITS_1_5 -> UsbSerialPort.STOPBITS_1_5
        StopBits.STOP_BITS_2 -> UsbSerialPort.STOPBITS_2
    }
}

internal fun Parity.toUsbSerialPort(): Int {
    return when (this) {
        Parity.NONE -> UsbSerialPort.PARITY_NONE
        Parity.ODD -> UsbSerialPort.PARITY_ODD
        Parity.EVEN -> UsbSerialPort.PARITY_EVEN
        Parity.MARK -> UsbSerialPort.PARITY_MARK
        Parity.SPACE -> UsbSerialPort.PARITY_SPACE
    }
}