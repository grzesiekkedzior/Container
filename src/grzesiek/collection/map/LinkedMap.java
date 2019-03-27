package grzesiek.collection.map;

public class LinkedMap<K, V> implements Map<K, V> {
	
	private Node<K, V> node = null;
	
	

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub

	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

}
