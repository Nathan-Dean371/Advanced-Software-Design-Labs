package ie.atu.sw;
import java.security.*;
import javax.crypto.Cipher;

public class RSACypher extends AbstractCypher 
{
	
	private KeyPair keyRing;
	
	public RSACypher() throws Throwable 
	{
		super();
		//Scope: Method
		//Composition Type: Dependency
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		
		//Scope: Class
		//Composition Type:
		keyRing = keyGen.generateKeyPair();
		
		//Scope: Aggregation
		//Composition Type: 
		super.setCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"));
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return super.encrypt(plainText, keyRing.getPublic());
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return super.decrypt(cypherText, keyRing.getPrivate());
	}
}
