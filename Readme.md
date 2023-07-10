# Java漏洞复现

## Apache Common Collections RCE
[Apache Common Collections RCE](https://github.com/PadishahIII/Java_Vulns_Poc/blob/master/demo/src/test/java/com/example/ApacheCommonCollection/TransformedMapTest.java)

## RMI反序列化
[rmi-client](https://github.com/PadishahIII/Java_Vulns_Poc/tree/master/RMI/rmi-client/src/main/java/rmi)
[RMI\rmi-server](https://github.com/PadishahIII/Java_Vulns_Poc/tree/master/RMI/rmi-server/src/main/java/rmi)

## JNDI注入（由于jdk版本不对，未复现成功）
[client](https://github.com/PadishahIII/Java_Vulns_Poc/tree/master/RMI/rmi-client/src/main/java/jndi)
[server](https://github.com/PadishahIII/Java_Vulns_Poc/tree/master/RMI/rmi-server/src/main/java/jndi)

## FastJson RCE
### JNDI利用
[fastjson](https://github.com/PadishahIII/Java_Vulns_Poc/blob/master/RMI/rmi-client/src/test/java/rmi/fastjsonTest.java)
服务端同JNDI

### 本地利用
https://github.com/PadishahIII/Spring_Demo/blob/master/src/test/java/com/example/fastjsonTest.java







