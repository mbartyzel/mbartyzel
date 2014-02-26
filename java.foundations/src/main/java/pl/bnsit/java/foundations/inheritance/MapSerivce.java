package pl.bnsit.java.foundations.inheritance;

import java.util.HashMap;
import java.util.Map;

public class MapSerivce {

	private static class Holder {
		private static final MapSerivce INSTANCE = new MapSerivce();
	}
	
	public static MapSerivce instance() {
		return Holder.INSTANCE;
	}
	
	private Map<String, String> distrincts = new HashMap<>();

	private MapSerivce() {
		distrincts.put("Lutomierska", "Bałuty");
		distrincts.put( "Henrykowska", "Widzew" );
		distrincts.put( "Żubardzka", "Bałuty" );
		distrincts.put("Dowborczyków", "Sródmieście");
		distrincts.put( "Pomorska", "Widzew" );
	}
	
	public String checkDistrinct( String street ) {
		return distrincts.get(street);
	}
	
}
