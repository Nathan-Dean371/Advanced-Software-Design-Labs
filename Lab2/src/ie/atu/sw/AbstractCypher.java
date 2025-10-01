package ie.atu.sw;
import java.security.Key;
import javax.crypto.Cipher;

public abstract class AbstractCypher implements Cypherable {

	private Cipher cypher;
	

	protected Cipher getCypher() {
		return cypher;
	}

	protected void setCypher(Cipher cypher) {
		this.cypher = cypher;
	}

	public AbstractCypher() {
		super();
	}
	
	public abstract byte[] encrypt(byte[] plainText) throws Throwable;
	public abstract byte[] decrypt(byte[] cypherText) throws Throwable;

	public byte[] encrypt(byte[] plainText, Key key) throws Throwable
	{
		getCypher().init(Cipher.ENCRYPT_MODE, key);
		return getCypher().doFinal(plainText);
	}


	public byte[] decrypt(byte[] cypherText, Key key) throws Throwable
	{
		getCypher().init(Cipher.DECRYPT_MODE, key);
		return getCypher().doFinal(cypherText);
	}
	
	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}