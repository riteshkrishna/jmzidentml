package uk.ac.ebi.jmzidml.model.utils;


import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.model.mzidml.Param;
import uk.ac.ebi.jmzidml.model.mzidml.UserParam;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 01/02/11
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class FacadeListTest {
    private FacadeList<CvParam> cvList;

    @Before
    public void setUp() throws Exception {
        List<Param> paramList = new ArrayList<Param>();

        CvParam cv = new CvParam();
        cv.setAccession("CV1");
        paramList.add(cv);

        CvParam cv1 = new CvParam();
        cv1.setAccession("CV2");
        paramList.add(cv1);

        UserParam user = new UserParam();
        user.setName("User1");
        paramList.add(user);

        UserParam user1 = new UserParam();
        user1.setName("User2");
        paramList.add(user1);

        CvParam cv2 = new CvParam();
        cv2.setAccession("CV3");
        paramList.add(cv2);

        CvParam cv3 = new CvParam();
        cv3.setAccession("CV4");
        paramList.add(cv3);

        UserParam user2 = new UserParam();
        user2.setName("User3");
        paramList.add(user2);

        cvList = new FacadeList<CvParam>(paramList, CvParam.class);
    }

    @Test
    public void testIteratorHasNext() throws NoSuchElementException {
        Iterator<CvParam> cvIter = cvList.iterator();
        // test hasnext
        cvIter.hasNext();
        cvIter.hasNext();
        cvIter.hasNext();
        cvIter.hasNext();
    }

    @Test
    public void testIteratorHasNextFailsAtEndOfList() {
        Iterator<CvParam> cvIter = cvList.iterator();
        cvIter.next();
        cvIter.next();
        cvIter.next();

        try {
            cvIter.next();
        } catch (NoSuchElementException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    public void testIteratorNext() {
        Iterator<CvParam> cvIter = cvList.iterator();

        // remove the first cv param
        CvParam cv = cvIter.next();
        assertTrue(cv.getAccession().equals("CV1"));
    }

    @Test
    public void testIteratorRemove() {
        Iterator<CvParam> cvIter = cvList.iterator();
        cvIter.next();
        cvIter.next();
        cvIter.remove();
        CvParam cv = cvIter.next();
        assertTrue(cv.getAccession().equals("CV3"));
    }

    /**
     * Get an iterator, call next one or more times then remove an instance from the list using the remove
     * method of list. Call next on the iterator again and check returned instance. This is to test the
     * consistency of the iterator.
     */
    @Test
    public void testIteratorInconsistency() {
        Iterator<CvParam> cvIter = cvList.iterator();

        // remove the first cv param
        cvIter.next();
        cvIter.next();
        cvIter.next();
        CvParam cv = cvIter.next();
        assertTrue(cv.getAccession().equals("CV4"));

        // remove one element
        cvList.remove(cv);

        // get next
        try {
            cv = cvIter.next();
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(ex instanceof NoSuchElementException);
        }
        //  assertTrue(false);
    }


    @Test
    public void testAdd() throws Exception {
        CvParam cv = new CvParam();
        cv.setAccession("CV5");
        this.cvList.add(cv);
        try {
            cv = this.cvList.get(4);
            assertTrue(cv.getAccession().equals("CV5"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullValue() throws Exception {
        this.cvList.add(null);
    }


    /**
     * Test adding at certain index.
     *
     * @throws Exception
     */
    @Test
    public void testAddAtIndex() {
        CvParam cv = new CvParam();
        cv.setAccession("CV5");
        this.cvList.add(1, cv);
        try {
            System.out.println(this.cvList.toString());
            cv = this.cvList.get(1);
            assertTrue(cv.getAccession().equals("CV5"));

            cv = this.cvList.get(4);
            assertTrue(cv.getAccession().equals("CV4"));
            System.out.println(this.cvList.toString());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testAddAtIndexWithIteratorBefore() {
        Iterator<CvParam> cvs = cvList.iterator();

        cvs.next();
        cvs.next();
        cvs.next();

        CvParam cv = new CvParam();
        cv.setAccession("New Cv 1");
        cvList.add(1, cv);

        assertTrue(cvs.next().getAccession().equals("CV3"));
    }

    @Test
    public void testAddAtIndexWithIteratorAfter() {
        Iterator<CvParam> cvs = cvList.iterator();

        cvs.next();
        cvs.next();

        CvParam cv = new CvParam();
        cv.setAccession("New Cv 4");
        cvList.add(3, cv);

        assertTrue(cvs.next().getAccession().equals("CV3"));

        assertTrue(cvs.next().getAccession().equals("New Cv 4"));

        assertTrue(cvs.next().getAccession().equals("CV4"));
    }


    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGetAtIndex() throws Exception {
        CvParam cv = this.cvList.get(0);
        assertTrue(cv.getAccession().equals("CV1"));
        cv = this.cvList.get(3);
        assertTrue(cv.getAccession().equals("CV4"));

    }

    /**
     * Test the case when an invalid index is used to try retrieve an element from the list.
     *
     * @throws Exception
     */
    @Test
    public void testGetAtIndexOutOfBounds() {
        CvParam cv = this.cvList.get(0);
        assertTrue(cv.getAccession().equals("CV1"));
        try {
            cv = this.cvList.get(4);
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testIndexOf() {
        CvParam cv = cvList.get(2);
        int index = cvList.indexOf(cv);
        assertTrue(index == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOfPassingNullReference() {
        int index = cvList.indexOf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOfProcessingNullReference() {
        cvList.set(2, null);

    }


    @Test
    public void testLastIndexOf() throws Exception {
        CvParam cv = cvList.get(1);
        cvList.add(cv);

        assertEquals(cvList.lastIndexOf(cv), 4);
    }

    @Test
    public void testListIteratorHasNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testListIteratorHasNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        assertTrue(it.hasNext());
    }

    @Test
    public void testListIteratorNotHasNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(4);
        assertTrue(!it.hasNext());
    }

    @Test
    public void testListIteratorNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        CvParam cv = it.next();
        assertTrue(cv.getAccession().equals("CV1"));
    }

    @Test
    public void testListIteratorNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        CvParam cv = it.next();
        assertTrue(cv.getAccession().equals("CV2"));
    }

    @Test
    public void testListIteratorLastNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(3);
        CvParam cv = it.next();
        assertTrue(cv.getAccession().equals("CV4"));
    }

    @Test (expected = NoSuchElementException.class)
    public void testListIteratorNoNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(4);
        it.next();
    }

    @Test
    public void testListIteratorHasPrevious() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        it.next();
        assertTrue(it.hasPrevious());
    }

    @Test
    public void testListIteratorHasNoPrevious() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        assertTrue(!it.hasPrevious());
    }

    @Test
    public void testListIteratorHasPreviousWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        assertTrue(!it.hasPrevious());
        it.next();
        assertTrue(it.hasPrevious());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testListIteratorNotHasPreviousWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(4);
        assertTrue(!it.hasPrevious());
    }


    @Test
    public void testSubList() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testContainsAll() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testRetainAll() throws Exception {

    }
}
