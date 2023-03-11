# Java漏洞复现

## Apache Common Collections RCE
demo\src\test\java\com\example\ApacheCommonCollection

## RMI反序列化
RMI\rmi-client
RMI\rmi-client\src\main\java\rmi
RMI\rmi-server
RMI\rmi-server\src\main\java\rmi

## JNDI注入（由于jdk版本不对，未复现成功）
RMI\rmi-client\src\main\java\jndi
RMI\rmi-server\src\main\java\jndi

## FastJson RCE
### JNDI利用
RMI\rmi-client\src\test\java\rmi\fastjsonTest.java
服务端同JNDI

### 本地利用
https://github.com/PadishahIII/Spring_Demo/blob/master/src/test/java/com/example/fastjsonTest.java







