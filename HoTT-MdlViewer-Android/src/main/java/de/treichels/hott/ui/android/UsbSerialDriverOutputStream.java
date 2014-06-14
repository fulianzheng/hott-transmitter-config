package de.treichels.hott.ui.android;

import java.io.IOException;
import java.io.OutputStream;

import android.util.Log;

import com.hoho.android.usbserial.driver.UsbSerialDriver;

/**
 * 
 * @author oli
 */
class UsbSerialDriverOutputStream extends OutputStream {
  private final UsbSerialDriver driver;
  private final byte[]          buffer = new byte[AndroidUsbSerialPortImplementation.BUFFER_SIZE];
  private int                   len    = 0;

  /**
   * @param driver
   */
  public UsbSerialDriverOutputStream(final UsbSerialDriver driver) {
    this.driver = driver;
  }

  @Override
  public void flush() throws IOException {
    if (len > 0) {
      final StringBuilder builder = new StringBuilder();
      for (int i = 0; i < len; i++) {
        builder.append(String.format("%02x ", buffer[i]));
      }

      byte[] b;
      if (len == AndroidUsbSerialPortImplementation.BUFFER_SIZE) {
        b = buffer;
      } else {
        b = new byte[len];
        System.arraycopy(buffer, 0, b, 0, len);
      }

      final int rc = driver.write(b, AndroidUsbSerialPortImplementation.IO_TIMEOUT);
      builder.append(": ").append(rc);

      Log.i("bulkUsbSerialDriver.write()", builder.toString());

      len = 0;
    }
  }

  @Override
  public void write(final int oneByte) throws IOException {
    buffer[len++] = (byte) oneByte;

    if (len == AndroidUsbSerialPortImplementation.BUFFER_SIZE) {
      flush();
    }
  }
}