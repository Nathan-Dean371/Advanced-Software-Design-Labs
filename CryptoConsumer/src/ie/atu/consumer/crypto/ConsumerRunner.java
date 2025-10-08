package ie.atu.consumer.crypto;

import ie.atu.sw.crypto.*;
import ie.atu.sw.crypto.symmetric.AESCypher;

public class ConsumerRunner {
public static void main(String[] args) throws Throwable{
CypherFactory cf = CypherFactory.getInstance();
Cypherable cypher = new AESCypher();
byte[] s = new String("HAPPY DAYS").getBytes("UTF-8");
byte[] t = cypher.encrypt(s);
System.out.println(new String(t));
System.out.println(new String(cypher.decrypt(t)));
}
}