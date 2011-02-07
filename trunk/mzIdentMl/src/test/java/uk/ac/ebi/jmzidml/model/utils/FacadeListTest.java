package uk.ac.ebi.jmzidml.model.utils;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.model.mzidml.Param;
import uk.ac.ebi.jmzidml.model.mzidml.UserParam;

import java.util.*;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 01/02/11
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class FacadeListTest {
    private List<Param> paramList;
    private FacadeList<CvParam> cvList;

    @Before
    public void setUp() throws Exception {
        paramList = new ArrayList<Param>();

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


    /**
     * Confirm subList() method returns a sublist with right size
     *
     * @throws Exception
     */
    @Test
    public void testSubList() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 3);
        assertTrue(sublist.size() == 2);
    }

    /**
     * Confirm the value returned by subList() is correct
     *
     * @throws Exception
     */
    @Test
    public void testSubListCheckValue() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 3);
        assertTrue(sublist.get(0).getAccession().equals("CV2"));
        Assert.assertTrue(sublist.get(1).getAccession().equals("CV3"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubListModification() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 3);
        CvParam cv = new CvParam();
        cv.setAccession("Rubbish");
        sublist.add(cv);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubListCheckIndex() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubListFromIndexGreaterThanToIndex() throws Exception {
        List<CvParam> sublist = cvList.subList(3, 2);
    }

    @Test
    public void testSubListToLastELement() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 4);
        Assert.assertTrue(sublist.size() == 3);
    }

    @Test
    public void testSubListChangeToOriginalList() throws Exception {
        List<CvParam> sublist = cvList.subList(1, 4);
        CvParam cv = sublist.get(0);
        cv.setAccession("New CV2");

        CvParam cv1 = cvList.get(1);
        Assert.assertTrue(cv1.getAccession().equals("New CV2"));
    }

    /**
     * Confirm toArray() returns an array with the right size
     *
     * @throws Exception
     */
    @Test
    public void testToArray() throws Exception {
        Object[] arr = cvList.toArray();
        Assert.assertTrue(arr.length == 4);
    }

    /**
     * Confirms changes on element instance within the array will be made to the original list as well.
     *
     * @throws Exception
     */
    @Test
    public void testToArrayChangeInstance() throws Exception {
        Object[] arr = cvList.toArray();
        CvParam cv = (CvParam) arr[0];
        cv.setAccession("CV12");
        Assert.assertTrue(cvList.get(0).getAccession().equals("CV12"));
    }

    /**
     * Changes to reference in returned array are not reflected in list. Setting an array element to a new object does
     * not change the reference in the original list.
     *
     * @throws Exception
     */
    @Test
    public void testToArrayChangeInstanceReference() throws Exception {
        Object[] arr = cvList.toArray();
        CvParam cv = new CvParam();
        cv.setAccession("CV12");
        arr[0] = cv;
        Assert.assertTrue(cvList.get(0).getAccession().equals("CV1"));
    }


    /**
     * ******************************* toArray(T[]) ********************************
     */
    @Test
    public void testToArrayProvidingArrayWithData() throws Exception {
        CvParam[] cvParams = new CvParam[6];
        CvParam cv = new CvParam();
        cv.setAccession("newCV1");
        cvParams[0] = cv;

        cv = new CvParam();
        cv.setAccession("newCV2");
        cvParams[1] = cv;

        cv = new CvParam();
        cv.setAccession("newCV3");
        cvParams[2] = cv;

        cv = new CvParam();
        cv.setAccession("newCV4");
        cvParams[3] = cv;

        cv = new CvParam();
        cv.setAccession("newCV5");
        cvParams[4] = cv;

        cv = new CvParam();
        cv.setAccession("newCV6");
        cvParams[5] = cv;

        CvParam[] returnedArray = this.cvList.toArray(cvParams);
        assertTrue(returnedArray[0].getAccession().equals("CV1"));
        assertTrue(returnedArray[4] == null);
        assertTrue(returnedArray[5].getAccession().equals("newCV6"));

    }

    @Test
    public void testToArrayProvidingArrayChangingValues() throws Exception {
        CvParam[] cvParams = new CvParam[5];
        CvParam[] returnedParams = this.cvList.toArray(cvParams);
        returnedParams[0].setAccession("newCV1");
        assertTrue(this.cvList.get(0).getAccession().equals(("newCV1")));
    }

    @Test
    public void testToArrayProvidingArrayChangingReference() throws Exception {
        CvParam[] cvParams = new CvParam[5];
        CvParam[] returnedParams = this.cvList.toArray(cvParams);
        CvParam newCvParam = new CvParam();
        newCvParam.setAccession("newCV1");
        returnedParams[0] = newCvParam;
        assertTrue(this.cvList.get(0).getAccession().equals(("CV1")));
    }


    @Test
    public void testToArrayProvidingArray() throws Exception {
        CvParam[] cvParams = new CvParam[5];
        CvParam[] returnedParams = this.cvList.toArray(cvParams);
        assertTrue(returnedParams[0].getAccession().equals(("CV1")));
        assertTrue(returnedParams[4] == null);
    }

    @Test
    public void testToArrayProvidingSmallerArray() throws Exception {
        CvParam[] cvParams = new CvParam[1];
        CvParam[] returnedParams = this.cvList.toArray(cvParams);
        assertTrue(returnedParams[0].getAccession().equals(("CV1")));
        assertTrue(returnedParams.length == 4);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayProvidingNullArray() throws Exception {
        CvParam[] nullArray = null;
        CvParam[] returnedParams = this.cvList.toArray(nullArray);
    }

    /************************** Test remove() ***********************************/
    /**
     * Remove an existing element from the sublist
     *
     * @throws Exception
     */
    @Test
    public void testRemove() throws Exception {
        CvParam cv = cvList.get(0);
        cvList.remove(cv);
        assertTrue(!cvList.contains(cv));
    }

    /**
     * Remove null should throw an NullPointerException
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveNullObject() throws Exception {
        cvList.remove(null);
    }

    /**
     * Remove a user param should throw a ClassCastException
     * @throws Exception
     */
    @Test (expected = ClassCastException.class)
    public void testRemoveUserParam() throws Exception {
        UserParam userParam = (UserParam)paramList.get(2);
        cvList.remove(userParam);
    }

    /**
     * Remove a cv param not in the list
     *
     * @throws Exception
     */
    @Test
    public void testRemoveNewCvParam() throws Exception {
        CvParam cv = new CvParam();
        cv.setAccession("NewCV");
        assertTrue(!cvList.remove(cv));
    }

    /********************************** containsAll ***********************************/
    @Test
    public void testContainsAll() throws Exception {
        List<CvParam> testList = new ArrayList<CvParam>();
        testList.add(this.cvList.get(0));
        testList.add(this.cvList.get(1));
        assertTrue(this.cvList.containsAll(testList));
    }

    @Test
    public void testContainsAllWithAdditionalCvParam() throws Exception {
        List<CvParam> testList = new ArrayList<CvParam>();
        testList.add(this.cvList.get(0));
        testList.add(this.cvList.get(1));
        CvParam cv = new CvParam();
        cv.setAccession("additionalCv");
        testList.add(cv);
        assertFalse(this.cvList.containsAll(testList));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAllWithNull() throws Exception {
        List<CvParam> testList = new ArrayList<CvParam>();
        testList.add(this.cvList.get(0));
        testList.add(this.cvList.get(1));
        testList.add(null);
        this.cvList.containsAll(testList);
    }


    @Test(expected = NullPointerException.class)
    public void testContainsAllWithNullCollection() throws Exception {
        this.cvList.containsAll(null);
    }


    @Test(expected = ClassCastException.class)
    public void testContainsAllWithWrongClasses() throws Exception {
        List testList = new ArrayList();
        testList.add("wrong class");
        testList.add(this.cvList.get(1));
        this.cvList.containsAll(testList);
    }

    @Test
    public void testClear() throws Exception {
        this.cvList.clear();
        assertTrue(this.cvList.size() ==0 );
        assertTrue(this.paramList.size() ==3);
        assertTrue(this.paramList.get(0).getName().equals("User1"));
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

    @Test
    public void testToArrayOnList() throws Exception {
        List<CvParam> list = new ArrayList<CvParam>();
        CvParam cv = new CvParam();
        cv.setAccession("CV1");
        list.add(cv);

        CvParam cv1 = new CvParam();
        cv1.setAccession("CV2");
        list.add(cv1);

        Object[] arr = list.toArray();
        CvParam newCv = new CvParam();
        newCv.setAccession("CV12");
        //   ((CvParam)arr[0]).setAccession("CV12");
        arr[0] = newCv;
        System.out.println(list.get(0).getAccession());
    }
}
