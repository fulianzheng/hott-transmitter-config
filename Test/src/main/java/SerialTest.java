import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.util.List;

import de.treichels.hott.internal.ClearScreen;
import de.treichels.hott.internal.CloseScreen;
import de.treichels.hott.internal.HoTTSerialPort;
import de.treichels.hott.internal.QueryTxInfo;
import de.treichels.hott.internal.QueryTxInfo.Response;
import de.treichels.hott.internal.ResetScreen;
import de.treichels.hott.internal.WriteScreen;

public class SerialTest {
  private static void dump(final byte[] data) {
    if (data == null) {
      return;
    }

    final int len = data.length;
    int addr = 0;
    while (addr < len) {
      System.out.printf("0x%04x:", addr);

      for (int i = 0; i < 16 && addr < len; i++) {
        final byte b = data[addr++];
        final char c = (char) (b & 0xff);
        if (c >= 0x20 && c <= 0x7e) {
          System.out.printf(" %c ", c);

        } else {
          System.out.printf(" %02x", b);
        }
      }

      System.out.println();
    }
  }

  public static void main(final String[] args) throws NoSuchPortException, UnsupportedCommOperationException, IOException, PortInUseException,
      InterruptedException {
    final List<String> ports = HoTTSerialPort.getAvailablePorts();

    System.out.println(ports);

    // WingedModel model = (WingedModel) HoTTDecoder.decode(ports.get(0), 0);
    // System.out.printf("ModelName: %s, TransmitterId: 0x%x, MemoryVersion: %d\n",
    // model.getModelName(), model.getTransmitterId(),
    // model.getMemoryVersion());
    //
    // model = (WingedModel) HoTTDecoder.decode(ports.get(0), 19);
    // System.out.printf("ModelName: %s, TransmitterId: 0x%x, MemoryVersion: %d\n",
    // model.getModelName(), model.getTransmitterId(),
    // model.getMemoryVersion());

    // model = (WingedModel) HoTTDecoder.decode(ports.get(0), 19);
    // System.out.printf("ModelName: %s, TransmitterId: 0x%x, MemoryVersion: %d\n",
    // model.getModelName(), model.getTransmitterId(),
    // model.getMemoryVersion());

    // HoTTSerialPort port = null;
    // try {
    // port = new HoTTSerialPort(ports.get(0));

    // {
    // final ServoPositions.Response response = (ServoPositions.Response)
    // port.doCommand(new ServoPositions());
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j < 8; j++) {
    // System.out.printf(" %d", response.getPosition(i * 8 + j));
    // }
    //
    // System.out.println();
    // }
    // }
    //
    // final ReadModelInformation cmd = new ReadModelInformation();
    // cmd.setModelNumber(19);
    // final ReadModelInformation.Response modelInformation =
    // (ReadModelInformation.Response) port.doCommand(cmd);
    //
    // if (modelInformation.getModelType() != ModelType.Unknown) {
    // System.out.printf("%d: %s, %d, %s, %s\n", 20,
    // modelInformation.getTransmitterType(), modelInformation.getVersion(),
    // modelInformation.getModelType(),
    // modelInformation.getModelName());
    // }
    //
    // final ReadModelMemory cmd2 = new ReadModelMemory();
    // final byte[] modelData = new byte[12288];
    // for (int i = 0; i < 6; i++) {
    // final int offset = 2048 * i;
    // cmd2.setAddress(offset);
    // final BaseResponse response = port.doCommand(cmd2);
    // System.arraycopy(response.getData(), 0, modelData, offset,
    // response.getLen());
    // }
    //
    // final ByteArrayInputStream is = new ByteArrayInputStream(modelData);
    // final WingedModel model = (WingedModel)
    // HoTTDecoder.decode(modelInformation.getModelType(),
    // modelInformation.getModelName(), is);
    // System.out.printf("TransmitterId: 0x%x, MemoryVersion: %d\n",
    // model.getTransmitterId(), model.getMemoryVersion());
    // } finally {
    // if (port != null) {
    // port.close();
    // }
    // }

    HoTTSerialPort port = null;
    try {
      port = new HoTTSerialPort(ports.get(0));
      final QueryTxInfo.Response response = (Response) port.doCommand(new QueryTxInfo());
      dump(response.getData());

      System.out.println(response.getResponseCode());
      System.out.println(response.getTransmitterType());
      System.out.println(response.getAppVersion());
      System.out.println(response.getMemoryVersion());
      System.out.println(response.getYear());
      System.out.println(response.getName());
      System.out.println(response.getVendor());

      port.doCommand(new ClearScreen());
      port.doCommand(new ResetScreen());
      port.doCommand(new WriteScreen(0, "---------------------"));
      port.doCommand(new WriteScreen(1, "* This is a test.   *"));
      port.doCommand(new WriteScreen(2, "*  This is a test.  *"));
      port.doCommand(new WriteScreen(3, "*   This is a test. *"));
      port.doCommand(new WriteScreen(4, "*    This is a test.*"));
      port.doCommand(new WriteScreen(5, "---------------------"));
      Thread.sleep(10000);
      port.doCommand(new CloseScreen());
    } finally {
      if (port != null) {
        port.close();
      }
    }
  }
}