package grzesiek.collection.map;

/*
 * This interface set elements in order were it put in the Map.
 */
public interface Map<K, V> {
	
	/**
	 * @param key
	 * @param value
	 */
	void put(K key, V value);
	
	/**
	 * @param key
	 * @return value asigned to the key
	 */
	V get(Object key);
	
	/**
	 * Remove value which is asigned to the key
	 * @param key
	 */
	void remove(Object key);
	
	/**
	 * @return true when map collection is not empty
	 */
	boolean isEmpty();
	
	/**
	 * @return size map collection
	 */
	int size();

}
