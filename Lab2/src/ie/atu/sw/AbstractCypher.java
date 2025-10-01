package ie.atu.sw;

import java.security.KeyPair;

import javax.crypto.Cipher;

public class AbstractCypher {

	protected Cipher cypher;
	protected KeyPair keyRing;

	public AbstractCypher() {
		super();
	}

	public byte[] encrypt(byte[] plainText) throws Throwable {
		cypher.init(Cipher.ENCRYPT_MODE, keyRing.getPublic());
		return cypher.doFinal(plainText);
	}

	public byte[] decrypt(byte[] cypherText) throws Throwable {
		cypher.init(Cipher.DECRYPT_MODE, keyRing.getPrivate());
		return cypher.doFinal(cypherText);
	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}