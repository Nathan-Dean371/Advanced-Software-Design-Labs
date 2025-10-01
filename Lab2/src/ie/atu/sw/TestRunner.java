package ie.atu.sw;

public class TestRunner {

	public static void main(String[] args) throws Throwable
	{
		//RSA Cipher
//		Cypherable rsaCypher = new RSACypher();
//		String text = "I am a message to encrypt";
//		byte[] encryptedMessage = rsaCypher.encrypt(text.getBytes("UTF-8"));
//		System.out.println(new String(encryptedMessage));
//		byte[] decryptedMessage = rsaCypher.decrypt(encryptedMessage);
//		System.out.println(new String(decryptedMessage));
//		
//		//DES Cipher
//		SymmetricCypher aesCypher = new SymmetricCypher("AES", 128, "AES/ECB/PKCS5Padding");
//		String aesText = "I am a message to encrypt with AES";
//		byte[] aesEncryptedMessage = aesCypher.encrypt(aesText.getBytes("UTF-8"));
//		System.out.println(new String(aesEncryptedMessage));
//		byte[] aesDecryptedMessage = aesCypher.decrypt(aesEncryptedMessage);
//		System.out.println(new String(aesDecryptedMessage));
//		
		
		CypherFactory cf = CypherFactory.getInstance();
		
		String aesText = "I am a message to encrypt with AES";
		Cypherable aesCypher = cf.getCypher(CypherStandard.AES);
		byte[] aesEncryptedMessage = aesCypher.encrypt(aesText.getBytes("UTF-8"));
		System.out.println(new String(aesEncryptedMessage));
		byte[] aesDecryptedMessage = aesCypher.decrypt(aesEncryptedMessage);
		System.out.println(new String(aesDecryptedMessage));
		
		
		String text = "I am a message to encrypt";
		Cypherable rsaCypher = cf.getCypher(CypherStandard.RSA);
		byte[] encryptedMessage = rsaCypher.encrypt(text.getBytes("UTF-8"));
		System.out.println(new String(encryptedMessage));
		byte[] decryptedMessage = rsaCypher.decrypt(encryptedMessage);
		System.out.println(new String(decryptedMessage));
		
		String desText = "I am a message to encrypt with DES";
		Cypherable desCypher = cf.getCypher(CypherStandard.DES);
		byte[] desEncryptedMessage = desCypher.encrypt(desText.getBytes("UTF-8"));
		System.out.println(new String(desEncryptedMessage));
		byte[] desDecryptedMessage = desCypher.decrypt(desEncryptedMessage);
		System.out.println(new String(desDecryptedMessage));
	}

}
