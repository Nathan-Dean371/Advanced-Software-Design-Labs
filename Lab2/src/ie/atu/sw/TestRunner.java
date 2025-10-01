package ie.atu.sw;

public class TestRunner {

	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
		AbstractCypher rsaCypher = new RSACypher();
		String text = "I am a message to encrypt";
		byte[] encryptedMessage = rsaCypher.encrypt(text.getBytes("UTF-8"));
		System.out.println(new String(encryptedMessage));
		byte[] decryptedMessage = rsaCypher.decrypt(encryptedMessage);
		System.out.println(new String(decryptedMessage));
	}

}
