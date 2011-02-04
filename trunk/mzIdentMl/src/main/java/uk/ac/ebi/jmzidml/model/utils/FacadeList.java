package uk.ac.ebi.jmzidml.model.utils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 26/01/11
 * Time: 10:16
 * <p/>
 * Controls access to a standard java list which contains more than one instance type, providing the developer with
 * a virtual list of a specified type. When this list is created, the developer must specify the class of interest.
 * Methods called on this class will be applied to the original list but will only act on instances of the specified
 * type.
 * For example, an originalList could contain a mixture of CvParams and UserParams. To work with a list of CvParams,
 * a developer creates an instance of this class passing in 'CvParam.class' as clazz in the constructor.
 * If the size method is called the list be searched and only instances of CvParam are counted towards the size.
 * Likewise, if get(3) (3 is the index) is called the 3rd instance of CvParam will be returned. Note, this CvParam might
 * not be the third element in the originallist.
 * <p/>
 * <p/>
 * TODO Implement CvParam and UserParam's toString, equals, hashcode. With equals objects are normally considered equals if contents match.
 * TODO Check iterator working with foreach
 * TODO check the checkIndex(), maybe not the best implementation
 * TODO finish all the add methods with checking the null input values
 */
public class FacadeList<T> implements List<T> {
    private static final String INDEX_ERROR_MESSAGE = "Input index should be greater than or equal than zero, and less than the size of the original list";
    public static final String SUBLIST_INDEX_ERROR_MESSAGE = "";
    private List originalList;
    private Class<T> clazz;

    public FacadeList(List originalList, Class<T> clazz) {
        if (originalList == null || clazz == null) {
            throw new IllegalArgumentException("Error: Neither original input list nor sublist class can be NULL");
        }
        this.originalList = originalList;
        this.clazz = clazz;
    }

    private FacadeList() {
        // set to private
    }

    public boolean add(T t) {
        checkArgument(t);
        return originalList.add(t);
    }

    /**
     * Remove a element from the original list
     * The index here is the index of the specified element int the original list
     *
     * @param index list index
     * @return T   element has been removed
     */
    public T remove(int index) {
        T elementAtIndex = this.getAtIndex(index);
        this.originalList.remove(elementAtIndex);
        return elementAtIndex;
    }

    /**
     * Get an element from the original list at index.
     *
     * @param index list index
     * @return T element to get
     */
    public T get(int index) {
        return this.getAtIndex(index);
    }

    /**
     * Set an new element based on the index of the sublist
     *
     * @param index   index of the sublist
     * @param element new element
     * @return T    old element in the position
     */
    public T set(int index, T element) {
        this.checkArgument(element);
        this.checkIndex(index);
        return this.setAtIndex(index, element);
    }

    /**
     * Get the size of the sublist
     *
     * @return int  size of the sublist
     */
    public int size() {
        int cnt = 0;

        for (Object anOriginalList : this.originalList) {

            if (clazz.isInstance(anOriginalList)) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * Check whether the sublist is empty
     *
     * @return boolean true means empty
     */
    public boolean isEmpty() {
        boolean em = false;

        for (Object anOriginalList : this.originalList) {
            Object o = anOriginalList;
            if (clazz.isInstance(o)) {
                em = true;
                break;
            }
        }

        return em;
    }

    /**
     * Check whether the sublist contains the element
     *
     * @param o input object
     * @return boolean     true means sublist contains the input object
     */
    public boolean contains(Object o) {
        checkArgument(o);
        return this.originalList.contains(o);
    }

    /**
     * Get an iterator of the sublist
     *
     * @return Iterator<T> an iterator of the sublist
     */
    public Iterator<T> iterator() {
        return new SublistIterator(this.originalList);
    }

    /**
     * Get the index of sublist using a given object
     *
     * @param o input object
     * @return int index of the object
     */
    public int indexOf(Object o) {
        checkArgument(o);
        int cnt = 0;
        for (Object anOriginalList : this.originalList) {
            if (clazz.isInstance(anOriginalList)) {
                if (o.equals(anOriginalList)) {
                    return cnt;
                }
                cnt++;
            }
        }
        return -1;
    }

    /**
     * Get the last index of sublist using a given object
     *
     * @param o input object
     * @return int index of the object
     */
    public int lastIndexOf(Object o) {
        checkArgument(o);

        int pointer = -1;
        int size = this.size();

        if (size > 0) {
            for (int i = (size - 1); i >= 0; i--) {
                if (o.equals(this.get(i))) {
                    pointer = i;
                    break;
                }
            }
        }

        return pointer;
    }

    public ListIterator<T> listIterator() {
        return new SubListListIterator(originalList);
    }

    public ListIterator<T> listIterator(int index) {
        return new SubListListIterator(originalList, index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object[] toArray() {
        return null;
    }


    public <T> T[] toArray(T[] a) {
        return null;
    }


    /**
     * Add a new element to the sublist
     * This will add the new element to the immediate index after the element at (index -1) in the sublist
     *
     * @param index   index of the sublist
     * @param element the new element
     */
    public void add(int index, T element) {
        this.checkArgument(element);
        this.checkIndex(index);
        this.addAtIndex(index, element);
    }


    public boolean remove(Object o) {
        return false;
    }


    public boolean containsAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void clear() {
    }


    public boolean addAll(Collection<? extends T> c) {
        this.checkArgument(c);
        return false;
    }


    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }


    public boolean removeAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean retainAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * This method is overridden to print out the list in concatenated string format
     *
     * @return String  list string
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");
        for (T element : this) {
            buffer.append("[");
            buffer.append(element.toString());
            buffer.append("], ");
        }
        if (this.size() > 0) {
            buffer.replace(buffer.length() - 2, buffer.length(), "");
        }

        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);    //To change body of overridden methods use File | Settings | File Templates.
    }

    /**
     * Check the legality of the argument
     * if illegal, then throw an IllegalArgument exception
     *
     * @param o Object to check
     */
    private void checkArgument(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Argument cannot be a null value");
        }
        if (!clazz.isInstance(o)) {
            throw new IllegalArgumentException("Argument must be an instance of " + clazz.getName() + ". Received instance of " + o.getClass().getName());
        }
    }

    /**
     * check whether the input index is greater or equal than zero, and less than the size of the original list
     *
     * @param index input index
     */
    private T getAtIndex(int index) {
        this.checkIndex(index);
        int cnt = 0;
        Iterator it = originalList.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (clazz.isInstance(o)) {
                if (index == cnt) {
                    return (T) o;
                }
                cnt++;
            }
        }
        throw new IndexOutOfBoundsException("Input index for sublist should be greater than or equal than zero, and less than the size of the list: " + index);
    }

    /**
     * TODO: Move this into set method if not reused in future.
     *
     * @param index
     * @param newElement
     * @return
     */
    private T setAtIndex(int index, T newElement) {
        int cnt = 0;
        int originalListIndex = this.getOriginalIndex(index);

        // check index and throw an exception
        this.checkIndex(originalListIndex, "Input sublist index doesn't exist" + index);

        return (T) this.originalList.set(originalListIndex, newElement);
    }

    /**
     * TODO: Move this into add at index method if not reused in future.
     *
     * @param index
     * @param newElement
     * @return
     */
    private void addAtIndex(int index, T newElement) {

        int originalListIndex = this.getOriginalIndex(index);

        this.checkIndex(originalListIndex, "Input sublist index doesn't exist" + index);

        this.originalList.add(originalListIndex, newElement);
    }

    /**
     * Get the index from the original list
     *
     * @param index index for the sublist
     * @return int index for the original list
     */
    private int getOriginalIndex(int index) {
        int cnt = 0;
        int originalListIndex = 0;

        for (Object element : originalList) {
            if (clazz.isInstance(element)) {
                if (index == cnt) {
                    break;
                }
                cnt++;
            }
            originalListIndex++;
        }

        return originalListIndex;
    }


    private void checkIndex(int index) {
        this.checkIndex(index, null);
    }

    private void checkIndex(int index, String errMsg) {
        if (index < 0 && index > (originalList.size() - 1)) {
            throw new IndexOutOfBoundsException(errMsg == null ? ("Input sublist index does not exist: " + index) : errMsg);
        }
    }

    private class SublistIterator implements Iterator<T> {
        private List superList;
        /**
         * Next position in the super list
         */
        private int nextPosition;
        private boolean nextHasBeenCalled = false;

        public SublistIterator(List superList) {
            this.superList = superList;
        }


        public boolean hasNext() {
            // check whether this is a next element in the super collection
            if (nextPosition <= (superList.size() - 1)) {
                // starting from the current position, loop through the super collection
                for (int i = nextPosition; i < superList.size(); i++) {
                    if (clazz.isInstance(superList.get(i))) {
                        return true;
                    }
                }
            }

            return false;
        }

        public T next() {
            // check whether this is a next element in the super collection
            if (nextPosition <= (superList.size() - 1)) {
                this.nextHasBeenCalled = true;
                // starting from the current position, loop through the super collection
                for (int i = nextPosition; i < superList.size(); i++) {
                    nextPosition++;
                    if (clazz.isInstance(superList.get(i))) {
                        return (T) superList.get(i);
                    }
                }
            }
            throw new NoSuchElementException("Sublist does not contain any more elements.");
        }

        public void remove() {
            if (this.nextHasBeenCalled == false) {
                throw new IllegalStateException("Next method for sublist iterator must be called at least once before remove can be called.");
            }
            this.nextPosition--;
            this.superList.remove(this.nextPosition);
        }
    }

    private class SubListListIterator implements ListIterator<T> {
        private List superList;
        /**
         * Next position in the super list
         */
        private int nextPosition;
        private int startSuperPosition = -1;
        private int startIndex;
        private boolean nextHasBeenCalled = false;

        private SubListListIterator(List superList) {
            this(superList, 0);
        }

        public SubListListIterator(List superList, int startIndex) {
            if (superList == null) {
                throw new NullPointerException("Input super list cannot be null");
            }

            if (startIndex < 0 || startIndex >= superList.size()) {
                throw new IllegalArgumentException("Start index of the iterator cannot be less than zero or greater-equal than the size of the list");
            }

            this.superList = superList;
            this.startIndex = startIndex;

            initNextPosition();
        }

        /**
         * set the nextPosition according the start index
         */
        private void initNextPosition() {
            if (this.startIndex > 0) {
                int cnt = 0;
                for (Object o : superList) {
                    if (clazz.isInstance(o)) {
                        if (cnt == this.startIndex) {
                            startSuperPosition = nextPosition;
                            nextPosition++;
                            break;
                        }
                        cnt++;
                    }
                    nextPosition++;
                }

                if (startSuperPosition == -1) {
                    throw new IndexOutOfBoundsException("Index out of the bound of the sublist: " + startIndex);
                }
            }
        }

        public boolean hasNext() {
            // check whether this is a next element in the super collection
            if (nextPosition <= (superList.size() - 1)) {
                // starting from the current position, loop through the super collection
                for (int i = nextPosition; i < superList.size(); i++) {
                    if (clazz.isInstance(superList.get(i))) {
                        return true;
                    }
                }
            }

            return false;
        }

        public T next() {
            // check whether this is a next element in the super collection
            if (nextPosition <= (superList.size() - 1)) {
                this.nextHasBeenCalled = true;
                // starting from the current position, loop through the super collection
                for (int i = nextPosition; i < superList.size(); i++) {
                    nextPosition++;
                    if (clazz.isInstance(superList.get(i))) {
                        return (T) superList.get(i);
                    }
                }
            }
            throw new NoSuchElementException("Sublist does not contain any more elements.");
        }

        public boolean hasPrevious() {
            if (nextPosition > 0) {
                for (int i = nextPosition - 1; i >= startSuperPosition; i--) {
                    if (clazz.isInstance(superList.get(i))) {
                        return true;
                    }
                }
            }

            return false;
        }

        public T previous() {
            if (nextPosition > 0) {
                for (int i = nextPosition - 2; i >= this.startSuperPosition; i--) {
                    nextPosition--;
                    if (clazz.isInstance(superList.get(i))) {
                        return (T) superList.get(i);
                    }
                }
            }

            throw new NoSuchElementException("Failed to find a previous element");
        }

        public int nextIndex() {
            int cnt = 0;
            int nextIndex = -1;
            // starting from the current position, loop through the super collection
            System.out.println("startSuperPosition: " + startSuperPosition);
            System.out.println("nextSuperPosition: " + nextPosition);
            for (int i = (startSuperPosition == 0 ? 0 : startSuperPosition); i < superList.size(); i++) {
                if (clazz.isInstance(superList.get(i))) {
                    System.out.println("Count: " + cnt);
                    if (nextIndex == -1 && i >= (this.nextPosition-1)) {
                        nextIndex = cnt;
                    }
                    cnt++;
                }
            }
            return nextIndex;
        }

        public int previousIndex() {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void remove() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void set(T t) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void add(T t) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
