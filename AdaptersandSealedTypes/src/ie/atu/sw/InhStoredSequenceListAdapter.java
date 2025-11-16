package ie.atu.sw;

public class InhStoredSequenceListAdapter extends StoredSequenceContext implements SequenceListStore
{

	public InhStoredSequenceListAdapter(CharSequence sequence) {
		super(sequence);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void store(CharSequence[] list) throws Exception {
		// TODO Auto-generated method stub
		for  (CharSequence cs : list)
		{
			super.store(cs);
		}
	}

}
