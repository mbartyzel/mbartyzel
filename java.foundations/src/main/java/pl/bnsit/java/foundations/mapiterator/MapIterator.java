package pl.bnsit.java.foundations.mapiterator;

import java.util.Iterator;
import java.util.Map;

import pl.bnsit.java.foundations.NotImplementedYetException;

public class MapIterator<K, V> {

	private Map<K, V> map;
	
	private Iterator<Map.Entry<K, V>> innerIterator;
	
	public MapIterator(Map<K, V> map) {
		this.map = map;
		this.innerIterator = map.entrySet().iterator();
	}

	public boolean hasNext() {
		return innerIterator.hasNext();
	}
	
	public void moveNext() {
		throw new NotImplementedYetException();
	}
	
	public K key() {
		throw new NotImplementedYetException();
	}
	
	public V value() {
		throw new NotImplementedYetException();
	}
	
}
