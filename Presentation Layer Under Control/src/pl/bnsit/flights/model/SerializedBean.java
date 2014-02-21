package pl.bnsit.flights.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class SerializedBean implements Serializable {

	private Long nextId = 1L;
	
	private Map<Long, Identifiable> map = new HashMap<Long, Identifiable>();
	
	public void put( Identifiable o ) {
		
		boolean notPersisted = ( o.getId() == null );
		if ( notPersisted ) {
			o.setId( nextId++ );
		}
		
		map.put( o.getId(), o );
	}
	
	public Identifiable find( Long id ) {
		return map.get( id );
	}
}
