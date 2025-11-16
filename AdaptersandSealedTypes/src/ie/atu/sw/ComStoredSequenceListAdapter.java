package ie.atu.sw;

public class ComStoredSequenceListAdapter implements SequenceListStore 
{
	private StoredSequenceContext ssc;
	
	public ComStoredSequenceListAdapter(CharSequence s)
	{
		ssc = new StoredSequenceContext(s);
		
	}

	@Override
	public void open(CharSequence fileName) throws Exception {
		// TODO Auto-generated method stub
		ssc.open(fileName);
	}

	@Override
	public void store(CharSequence[] list) throws Exception {
		// TODO Auto-generated method stub
		for  (CharSequence cs : list)
		{
			ssc.store(cs);
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		ssc.close();
	}
}
