package uk.ac.ebi.jmzidml.model.utils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 26/01/11
 * Time: 10:16
 *
 * Controls access to a standard java list which contains more than one instance type, providing the developer with
 * a virtual list of a specified type. When this list is created, the developer must specify the class of interest.
 * Methods called on this class will be applied to the original list but will only act on instances of the specified
 * type.
 * For example, an originalList could contain a mixture of CvParams and UserParams. To work with a list of CvParams,
 * a developer creates an instance of this class passing in 'CvParam.class' as clazz in the constructor.
 * If the size method is called the list be searched and only instances of CvParam are counted towards the size.
 * Likewise, if get(3) (3 is the index) is called the 3rd instance of CvParam will be returned. Note, this CvParam might
 * not be the third element in the originallist.
 */
public class FacadeList<T> implements List<T> {
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
        checkArugment(t);
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
        T elementAtIndex = this.getAtIndex(index);
        return elementAtIndex;
    }

    /**
     * Set an new element based on the index of the sublist
     *
     * @param index   index of the sublist
     * @param element new element
     * @return T    old element in the position
     */
    public T set(int index, T element) {
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
            Object o = anOriginalList;
            if (clazz.isInstance(o)) {
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
        checkArugment(o);
        return this.originalList.contains(o);
    }


    public Iterator<T> iterator() {
        return new SublistIterator(this.originalList);
    }

    public int indexOf(Object o) {
        return -1;
    }

    public int lastIndexOf(Object o) {
        return -1;
    }

    public ListIterator<T> listIterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ListIterator<T> listIterator(int index) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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


    public void add(int index, T element) {

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
     * Check the legality of the argument
     * if illegal, then throw an IllegalArgument exception
     *
     * @param o Object to check
     */
    private void checkArugment(Object o) {
        //todo: may be change this to instanceof ?
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
        this.checkIndex(index);
        int cnt = 0;
        int originalListIndex = 0;
        Iterator it = originalList.iterator();

        while (it.hasNext()) {
            Object o = it.next();
            if (clazz.isInstance(o)) {
                if (index == cnt) {
                    break;
                }
                cnt++;
            }
            originalListIndex++;
        }
        if (originalListIndex >= this.originalList.size()) {
            throw new IndexOutOfBoundsException("Input index for sublist should be greater than or equal than zero, and less than the size of the list: " + index);
        }
        return (T) this.originalList.set(originalListIndex, newElement);
    }

    private void checkIndex(int index) {
        if (index < 0 && index > (originalList.size() - 1)) {
            throw new IndexOutOfBoundsException("Input index should be greater than or equal than zero, and less than the size of the list: " + index);
        }
    }

    private class SublistIterator implements Iterator<T> {
        private List superCollection;
        private int currentPosition = 0;
        private boolean nextHasBeenCalled = false;
        public SublistIterator(List superCollection) {
            this.superCollection = superCollection;
        }


        public boolean hasNext() {
           // check whether this is a next element in the super collection
            if (currentPosition <= (superCollection.size() - 1)) {
                // starting from the current position, loop through the super collection
                for (int i = currentPosition; i < superCollection.size(); i++) {
                    if (clazz.isInstance(superCollection.get(i))) {
                        return true;
                    }
                }
            }

            return false;
        }

        public T next() {
            // check whether this is a next element in the super collection
            if (currentPosition <= (superCollection.size() - 1)) {
                this.nextHasBeenCalled = true;
                // starting from the current position, loop through the super collection
                for (int i = currentPosition; i < superCollection.size(); i++) {
                    currentPosition ++;
                    if (clazz.isInstance(superCollection.get(i))) {
                        return (T)superCollection.get(i);
                    }
                }
            }
            throw new NoSuchElementException("Sublist does not contain any more elements.");
        }

        public void remove() {
            if(this.nextHasBeenCalled == false){
                throw new IllegalStateException("Next method for sublist iterator must be called at least once before remove can be called.");
            }
            this.currentPosition--;
            this.superCollection.remove(this.currentPosition);
        }
    }
}
