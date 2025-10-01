package ie.atu.sw;
import java.security.*;
import javax.crypto.Cipher;

public class RSACypher extends AbstractCypher 
{
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
		cypher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	}
	
	
}
