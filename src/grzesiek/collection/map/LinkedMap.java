package grzesiek.collection.map;

/**
 * @author grzesiek
 *
 * @param <K>
 * @param <V>
 */
public class LinkedMap<K, V> implements Map<K, V> {

	private Node<K, V> top = null;
	private Node<K, V> current = null;
	private Node<K, V> last = null;

	/**
	 * Default constructor.
	 */
	public LinkedMap() {
	}

	/**
	 * @param key
	 * @param value
	 */
	public LinkedMap(K key, V value) {
		top = new Node<>(key, value);
	}

	@Override
	public void put(K key, V value) {

		if (key != null)
			current = new Node<>(key, value);

		if (checkIffindKey(key, value)) {
			Node<K, V> findekey = top;
			while (findekey != null) {
				if (findekey.key.equals(key))
					findekey.value = value;
				else
					break;
				findekey = findekey.next;

			}

		} else {
			while (current != null) {
				if (top == null) {
					top = current;
				} else
					last.next = current;
				last = current;
				break;
			}

		}

	}

	private boolean checkIffindKey(K key, V value) {
		Node<K, V> findekey = top;
		boolean colisionkey = false;
		while (findekey != null) {
			if (findekey.key.equals(key)) {
				colisionkey = true;
			} else {
				break;
			}
			findekey = findekey.next;

		}
		return colisionkey;
	}

	@Override
	public V get(Object key) {
		if (key == null)
			return (V) new NullPointerException();

		Node<K, V> searchingkey = top;

		while (key != null) {
			if (searchingkey != null && searchingkey.key.equals(key)) {
				return searchingkey.value;
			} else {
				searchingkey = searchingkey.next;
			}
		}

		return null;
	}

	@Override
	public void remove(Object key) {
		//TODO
	}

	@Override
	public boolean isEmpty() {
		if (top != null)
			return false;
		return true;
	}

	@Override
	public int size() {
		Node<K, V> sizenode = top;
		int size = 0;
		while (sizenode != null) {
			sizenode = sizenode.next;
			size++;
		}
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current == null) ? 0 : current.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((top == null) ? 0 : top.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LinkedMap))
			return false;
		LinkedMap other = (LinkedMap) obj;
		if (current == null) {
			if (other.current != null)
				return false;
		} else if (!current.equals(other.current))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
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
