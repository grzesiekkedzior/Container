package container;

/**
 * This interface has several methods which allow duplicate elements.
 * <p>
 * The user can access elements by its integer index.
 * <p>
 * Only two methods returns value.
 * 
 * @param <T> Type of collection element
 */
public interface List<T> extends Iterable<T>{

	/**
	 * Show all elements.
	 */
	void showAll();
	/**
	 * Appends the specified element to the end of this list.
	 * @param n element to be stored at the first position
	 */
	void addOnBack(T n);
	/**
	 * Appends the specified element to the list.
	 * @param n element to be stored at the end position
	 */
	void add(T n);
	/**
	 * Appends the specified generic element for the next smallest element.
	 * @param n element to be stored at the sorted position
	 */
	void addSorted(T n);
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	int size();
	/**
	 * Returns the element at the specified position in this list.
	 * @param n element to be at the specified position
	 * @return element to be at the specified position
	 */
	T getNode(int n);
	/**
	 * Removes the element at the specified position in this list.
	 * @param n remove element to be at the specified position
	 */
	void removeNode(int n);
	/**
         * This method generated Array.
         * @param <T> Type of element
         * @param arr An array created to past elements for itsselfs
         * @return Return the new array
         */
	<T> T[] toArray(T[] arr);
    /**
     * This method sort List but not exactly the same but return new one.
     * @return new linked List
     */
    List<T> sort();


}
