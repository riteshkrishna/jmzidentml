package uk.ac.ebi.jmzidml.model.utils;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.model.mzidml.Param;
import uk.ac.ebi.jmzidml.model.mzidml.UserParam;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 04/02/11
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class FacadeListIteratorTest {
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
    public void testListIteratorHasNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testListIteratorHasNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        assertTrue(it.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListIteratorNotHasNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(4);
    }

    @Test
    public void testListIteratorNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        CvParam cv = it.next();
        System.out.println("CV Accession: " + cv.getAccession());
        assertTrue(cv.getAccession().equals("CV1"));
    }

    @Test
    public void testListIteratorNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        CvParam cv = it.next();
        System.out.println("Cv Accession:" + cv.getAccession());
        assertTrue(cv.getAccession().equals("CV2"));
    }

    @Test
    public void testListIteratorLastNextWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(3);
        CvParam cv = it.next();
        assertTrue(cv.getAccession().equals("CV4"));
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListIteratorNotHasPreviousWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(4);
        assertTrue(!it.hasPrevious());
    }

    /**
     * Try to retrieve previous element before next has been called.
     *
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testPreviousFromStart() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        it.previous();
    }

    @Test
    public void testPrevious() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        it.next();
        CvParam cv = it.previous();
        assertNotNull(cv);
        assertTrue(cv.getAccession().equals("CV1"));
    }

    /**
     * Pass an index into listiterator call and call previous. Should throw Exception
     *
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testPreviousFailingWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        it.previous();
    }


    @Test
    public void testNextIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        int nextIndex = it.nextIndex();
        assertTrue(nextIndex == 0);
    }

    @Test
    public void testNextIndexWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(2);
        int nextIndex = it.nextIndex();
        assertTrue(nextIndex == 0);
    }

    @Test
    public void testNextIndexWithIndexEnd() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(3);
        int nextIndex = it.nextIndex();
        assertTrue(nextIndex == 0);
    }

    @Test
    public void testNextIndexWithIndexSize() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(3);
        it.next();
        int nextIndex = it.nextIndex();
        System.out.println("nextIndex: " + nextIndex);
        assertTrue(nextIndex == 1);
    }

    @Test
    public void testPreviousIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        it.next();
        int previousIndex = it.previousIndex();
        assertTrue(previousIndex == 0);
    }

    @Test
    public void testPreviousIndexWithOutNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator();
        int previousIndex = it.previousIndex();
        assertTrue(previousIndex == -1);
    }

    @Test
    public void testPreviousIndexWithIndex() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        it.next();
        it.next();
        int previousIndex = it.previousIndex();
        assertTrue(previousIndex == 1);
    }

    @Test
    public void testPreviousIndexWithoutNext() throws Exception {
        ListIterator<CvParam> it = cvList.listIterator(1);
        int previousIndex = it.previousIndex();
        assertTrue(previousIndex == -1);
    }


    @Test
    public void testEmptySuperListHasNext() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        assertTrue(!it.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void testEmptySuperListNext() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        it.next();
    }

    @Test
    public void testEmptySuperListHasPrevious() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        assertTrue(!it.hasPrevious());
    }

    @Test (expected = NoSuchElementException.class)
    public void testEmptySuperListPrevious() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        it.previous();
    }

    @Test
    public void testEmptySuperListNextIndex() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        int nextIndex = it.nextIndex();
        assertTrue(nextIndex == 0);
    }

    @Test
    public void testEmptySuperListPreviousIndex() throws Exception {
        List superlist = new ArrayList();
        FacadeList list = new FacadeList(superlist, CvParam.class);
        ListIterator it = list.listIterator();
        int previousIndex = it.previousIndex();
        assertTrue(previousIndex == -1);
    }

    @Test
    public void testNextPositionatminusone() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        ListIterator listIt = list.listIterator();
        listIt.next();
        if (listIt.hasPrevious()) {
            System.out.println("hasprevious");
            String value = (String) listIt.previous();
            System.out.println("value " + value);
        }

    }

    @Test
    public void testNextPositionAtZero() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        ListIterator listIt = list.listIterator();
        listIt.next();
        int previous = listIt.previousIndex();
        System.out.println(previous);

    }
}
