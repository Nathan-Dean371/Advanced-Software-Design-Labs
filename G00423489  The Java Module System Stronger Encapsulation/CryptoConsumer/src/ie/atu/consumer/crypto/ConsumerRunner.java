package ie.atu.consumer.crypto;

import ie.atu.sw.crypto.*;
import ie.atu.sw.crypto.symmetric.AESCypher;
import ie.atu.sw.crypto.symmetric.VigenereCypher;


public class ConsumerRunner {
	public static void main(String[] args) throws Throwable {
		
		
		//Cypherable cypher = new AESCypher();
		
		Cypherable vigCypher = new VigenereCypher();
		byte[] s = new String("HAPPYDAYS").getBytes("UTF-8");
		byte[] t = vigCypher.encrypt(s);
		
		System.out.println("Vigenere Cypher Example");
		System.out.println(new String(t));
		System.out.println(new String(vigCypher.decrypt(t)));
		
	}
}