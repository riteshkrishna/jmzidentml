package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.Cv;
import uk.ac.ebi.jmzidml.model.mzidml.CvList;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */

public class CvListTest extends TestCase {

    Logger logger = Logger.getLogger(CvListTest.class);


    public void testCvListInformation() throws Exception {

        URL xmlFileURL = CvListTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        // Number of providers
        int totalCv = unmarshaller.getObjectCountForXpath("/mzIdentML/cvList");
        assertEquals(1,totalCv);

        CvList cvlist = unmarshaller.unmarshalFromXpath("/mzIdentML/cvList",CvList.class);
        Iterator <Cv> cvs = cvlist.getCv().iterator();
        assertEquals(3,cvlist.getCv().size());

        while(cvs.hasNext()){
            Cv cv = cvs.next();
            System.out.println("Cv -> Name : " + cv.getFullName() + "\t URI : " + cv.getURI());
        }

    }

}
