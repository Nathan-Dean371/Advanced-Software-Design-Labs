package ie.atu.sw.crypto.symmetric;

import ie.atu.sw.crypto.*;
import ie.atu.classic.vigenere.*;

/*
 * Blaise de Vigenere, a  French diplomat, is incorrectly accredited with inventing this encryption mechanism in the 1570s,
 * as the technique is mentioned in a book by the aristocratic Giovani Battista Bellaso that was piublished in 1553. In 1863,
 * the first crypto-analytic technique for breaking was reported by Friedrich Kasiski, an officer in the Prussian army.  
 */
public class VigenereCypher extends AbstractCypher {
	
	private Vigenere v = new Vigenere(); // Compose
	
	public void setKey(String key) {
		v.setKey(key); // Delegate
	}

	public byte[] encrypt(byte[] plainText) throws Throwable {
		return v.doCypher(plainText, true); // Delegate
	}

	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return v.doCypher(cypherText, false); // Delegate
	}
}