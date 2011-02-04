package uk.ac.ebi.jmzidml.model.utils;


import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.model.mzidml.Param;
import uk.ac.ebi.jmzidml.model.mzidml.UserParam;

import java.util.*;

import static junit.framework.Assert.assertNotNull;
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

            cv = this.cvList.get(1);
            assertTrue(cv.getAccession().equals("CV5"));

            cv = this.cvList.get(4);
            assertTrue(cv.getAccession().equals("CV4"));

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
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
