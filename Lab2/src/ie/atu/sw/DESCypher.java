package ie.atu.sw;

import javax.crypto.KeyGenerator;

public class DESCypher extends AbstractCypher 
{

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		// TODO Auto-generated method stub
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(128);
		Key key = keyGen.generateKeyPair();
		return super.encrypt(plainText);
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		// TODO Auto-generated method stub
		return super.decrypt(cypherText);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
}
