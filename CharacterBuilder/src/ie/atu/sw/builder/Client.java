package ie.atu.sw.builder;

public class Client 
{
	public static void main(String[] args) throws Exception 
	{
		CharacterDirector characterDirector = new CharacterDirector();
		
		for ( int i = 33; i < 10000; i++)
		{
			characterDirector.append((char)i);
		}
		
		System.out.println(characterDirector.getCharSequence());
	}
}
