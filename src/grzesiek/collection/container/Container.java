package grzesiek.collection.container;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * This is implementation of List interface.
 * <p>
 * The main algorithm which is used is linked list. The method addSorted for
 * many items is slow.
 * <p>
 * If you want add only one element unsorted use only add method.
 * <p>
 * Example:
 * 
 * <pre>
 * {@code
 * Constructor cannot be empty. There is no capacity initialize value.
 *
 * List<Integer> list = new Container<>(1, 2, 3, 4);
 * list.add(1);
 * list.showAll();
 *
 * int[] arr = {1, 2, 3, 4};
 * List<Integer> list = new Container(arr);
 * list.showAll();
 *
 * If you are going to change your list to array is one method to do that
 * for simple way.
 *
 * List<Integer> list = new Container<>(1, 2, 3, 4);
 * Integer[] arr = new Integer[nevermind how capacity you put to array];
 * toArray() method change capacity.
 *
 * arr = list.toArray(arr);
 *
 * To print console:
 * for(int i : arr) {System.out.println(i)};
 *
 * In this project is implemented own interface Iterable<T>
 * It can be use like usually.
 * For exaample:
 *
 * List<Integer> list = new Container<>(1, 2, 3, 4);
 * for(int i : list) { System.out.println(i); }
 *
 * In that case it can be use lambda expression.
 *
 * list.forEach(num -> { System.out.println(num); });
 *
 * Simplier is use method reference:
 *
 * list.forEach(System.out::println);
 *
 * The sort() method return new List.
 *
 * List<Integer> list = new List<>(5, 4, 3, 2, 1);
 * List<Integer> secondList = list.sort();
 * return secondList -> 1, 2, 3, 4, 5
 *
 * If you want reverse elements of collection just use reverse method.
 * <p>
 * It return new List reverse elements.
 *
 * }
 * </pre>
 *
 * @author Grzegorz Kedzior
 * @param <T> Type of collection element
 */
public class Container<T> implements List<T> {

	private Element<T> top = null;
	private Element<T> current = null;
	private Element<T> last = null;
	private Element<T> insert = null;
	private Element<T> previous = null;
	Optional<T> optional = Optional.empty();

	/**
	 * Construct an list which get array of integer elements.
	 *
	 * @param tab the array contain collection
	 */
	public Container(int tab[]) {
		for (int a : tab) {
			T t = (T) (Integer) a;
			this.add(t);
		}
	}

	/**
	 * Construct an list which get array of double elements.
	 *
	 * @param tab the array contain collection
	 */
	public Container(double tab[]) {
		for (double a : tab) {
			T t = (T) (Double) a;
			this.add(t);
		}
	}

	/**
	 * Construct an list which get array of Generic elements.
	 *
	 * @param tab the runtime type of the array to contain the collection
	 */
	public Container(String tab[]) {
		for (String t : tab) {
			this.add((T) t);
		}
	}

	/**
	 * Construct which agregate many elements.
	 *
	 * @param args collection elements
	 */
	public Container(T... args) {
		this.of(args);
	}

	/**
	 * Appends the specified element to the list.
	 */
	@Override
	public void add(T n) {
		optional = Optional.ofNullable(n);
		while (optional.isPresent()) {
			current = new Element<>(n);
			if (top == null) {
				top = current;
			} else {
				last.next = current;
			}
			last = current;
			break;
		}

	}

	/**
	 * Appends the specified element before the first.
	 */
	@Override
	public void addOnBack(T n) {
		optional = Optional.ofNullable(n);
		if (optional.isPresent()) {

			current = new Element<>(n);
			current.next = top;

			top = current;
		}
	}

	/**
	 * Show all elements.
	 */
	@Override
	public void showAll() {
		current = top;
		while (current != null) {
			System.out.println(current.num);
			current = current.next;
		}
	}

	/**
	 * Appends the specified generic element for the next smallest element.
	 */
	@Override
	public void addSorted(T n) {

		int a = 0;
		int b = 0;
		insert = new Element<>(n);
		previous = null;
		current = top;
		if (current != null && current.num instanceof Integer) {
			a = (Integer) n;
		}

		while (current != null && current.num instanceof Integer && (b = (Integer) current.num) < a) {
			previous = current;
			current = current.next;
		}

		while (current != null && current.num instanceof String
				&& current.num.toString().compareToIgnoreCase(n.toString()) < 0) {
			previous = current;
			current = current.next;
		}

		insert.next = current;
		if (previous == null) {
			top = insert;
		} else {
			previous.next = insert;
		}
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		int size = 0;
		current = top;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	@Override
	public T getNode(int n) {
		int size = this.size();
		Element<T> searchingNumber = top;
		Element<T> target = null;
		T t = null;
		if (n <= size() && searchingNumber != null) {
			for (int a = 0; a < n; a++) {
				target = searchingNumber;
				searchingNumber = searchingNumber.next;
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		if (target != null) {
			t = target.num;
		} else {
			throw new NullPointerException();
		}

		return t;
	}

	/**
	 *
	 * @return first top list reference
	 */
	public Element<T> getTop() {
		return this.top;
	}

	/**
	 * This method agregate many elements.
	 *
	 * @param args varargs elements
	 */
	public void of(T... args) {
		for (T element : args) {
			this.add(element);
		}
	}

	/**
	 * Removes the element at the specified position in this list.
	 */
	@Override
	public void removeNode(int n) {
		if (n <= 0 || n > size()) {
			System.out.println("indexOut");
		} else {
			if (n == 1) {
				top = top.next;
			}
			current = null;
			current = top;

			if (current != null) {
				for (int a = 1; a < n; a++) {
					previous = current;
					current = current.next;
				}
			}

			if (n > 1) {
				previous.next = current.next;
			}
		}

	}

	public void addIndex(int index, T n) {

		if (index <= 0 || index > size()) {
			System.out.println("indexOut");
		} else {
			insert = new Element<>(n);
			if (index == 1) {
				
				insert.next = top;

				top = insert;
			}
			current = null;
			current = top;

			if (current != null) {

				for (int a = 1; a < index; a++) {

					current = current.next;
					previous = current;
				}
			}

			if (index > 1) {
				this.removeNode(index);
				previous.next = insert;
				insert.next = current;
			}
		}

	}

	/**
	 * This method generated Array.
	 *
	 * @param <T> Type of element
	 * @param arr An array created to past elements for itsselfs
	 * @return Return the new array
	 */
	@Override
	public <T> T[] toArray(T[] arr) {
		Class<T> type = (Class<T>) arr.getClass().getComponentType(); // return object reference type
		int i = 0;
		T[] tab = (T[]) Array.newInstance(type, this.size());

		current = top;
		while (current != null) {
			tab[i] = (T) current.num;
			current = current.next;
			i++;
		}

		return tab;
	}

	/**
	 * This method sort List but not exactly the same but return new one.
	 *
	 * @param <T> Type of element
	 * @return new linked List
	 */
	@Override
	public List<T> sort() {
		List<T> l = new Container();
		for (T t : this) {
			l.addSorted(t);
		}

		return l;
	}

	/**
	 * This method revers all collection of element.
	 *
	 * @return new List of revers elements
	 */
	@Override
	public List<T> reverse() {
		List<T> l = new Container();
		for (int i = this.size(); i > 0; i--) {
			l.add(this.getNode(i));
		}

		return l;
	}

	@Override
	public void forEach(Consumer<? super T> action) {
		for (T t : this) {
			action.accept(t);
		}
	}

	@Override
	public Iterator<T> iterator() {

		List<T> l = this;
		Iterator<T> it = new Iterator<T>() {

			int currentIndex = 1;

			@Override
			public boolean hasNext() {
				return currentIndex <= l.size() && l.getNode(currentIndex) != null;
			}

			@Override
			public T next() {
				return l.getNode(currentIndex++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
		return it;
	}

	@Override
	public Spliterator<T> spliterator() {
		return null;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	@Override
	public boolean contains(Object o) {
		int size = this.size();
		if (o == null) {
			for (int i = 1; i < size; i++) {
				if (this.getNode(i) == null)
					;
			}
			return false;
		} else {
			for (int i = 1; i < size; i++) {
				if (o.equals(this.getNode(i))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns a view of the portion of this list between the specified fromIndex,
	 * inclusive, and toIndex, exclusive.
	 *
	 * @param fromIndex low endpoind of the sublist
	 * @param toIndex   high endpoint of the sublist
	 *
	 * @return new sublist
	 */
	public List<T> subList(int fromIndex, int toIndex) {
		int size = this.size();
		List<T> l = new Container<>();
		if (fromIndex < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (toIndex > size) {
			throw new IndexOutOfBoundsException();
		}

		if (fromIndex < 0 || toIndex <= size || fromIndex < toIndex) {
			for (int i = fromIndex; i <= toIndex; i++) {
				l.add(this.getNode(i));
			}
		}

		return l;
	}

	/**
	 * Removes all of the elements from this list
	 */
	@Override
	public void clear() {
		int size = this.size();
		for (int i = 1; i < size; i++) {
			this.add(null);
		}
		this.top = null;
		this.current = null;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		int size = this.size();
		if (size < 1) {
			return true;
		} else {
			return false;
		}
	}
}

/**
 * @author grzesiek This class is only used to create toolchain reference.
 * @param <T> the type of elements in this list
 */
class Element<T> {

	T num;
	Element<T> next;

	public Element(T n) {
		num = n;
		next = null;
	}
}
