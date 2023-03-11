import java.rmi.RemoteException;

public class MyClientTest {

  public static void main(String args[]) throws RemoteException {
    MyClient client = new MyClient("127.0.0.1", 1099);
    System.out.println(client.getRmtDate());
    System.out.println(client.rmtAdd(1, 2));
  }
}
