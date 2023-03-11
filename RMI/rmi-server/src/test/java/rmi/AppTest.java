package rmi;

import java.rmi.Naming;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  /**
   * Rigorous Test :-)
   */
  @Test
  public void ServerTest() {
    try {
      RmtServer rmtServer = new MyServer();
      Naming.rebind("MyServer", rmtServer);
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }
}
