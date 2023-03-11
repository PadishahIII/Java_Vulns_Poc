import java.rmi.Naming;

public class MyServerTest {
    public  static void main(String args[]){
        try{
            RmtServer rmtServer = new MyServer();
            Naming.rebind("MyServer", rmtServer);
        }catch(java.io.IOException e){
            e.printStackTrace();
        }

    }
}
