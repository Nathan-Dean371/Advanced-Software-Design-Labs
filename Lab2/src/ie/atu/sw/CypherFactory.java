package ie.atu.sw;

public class CypherFactory 
{
	private static CypherFactory cf = new CypherFactory();
	
	private CypherFactory()
	{
		
	}
	
	public static CypherFactory getInstance()
	{
		return cf;
	}
	
	public Cypherable getCypher(CypherStandard type) throws Throwable
	{
		//Using a switch makes adding more cyphers better over an if
		return switch (type) {
		case AES -> new SymmetricCypher("AES", 128, "AES/ECB/PKCS5Padding");
		case DES -> new SymmetricCypher("DES", 56, "DES/ECB/PKCS5Padding");
		default ->	new RSACypher();
		};
	}
}
