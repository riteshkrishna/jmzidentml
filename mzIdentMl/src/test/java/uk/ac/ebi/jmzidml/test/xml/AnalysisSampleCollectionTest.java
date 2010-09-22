package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */
public class AnalysisSampleCollectionTest extends TestCase {

    private static final Logger log = Logger.getLogger(AnalysisSampleCollectionTest.class);


    public void testAnalysisSampleCollectionInformation() throws Exception {

        URL xmlFileURL = AnalysisSampleCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        AnalysisSampleCollection asc =  unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisSampleCollection", AnalysisSampleCollection.class);
        assertNotNull(asc);

        assertEquals(1, asc.getSample().size());
        for (Sample sample : asc.getSample()) {
            log.debug("Analysis Sample : Name = " + sample.getName());
            for (ContactRole contactRole : sample.getContactRole()) {
                assertNotNull(contactRole.getContact().getName());
                log.debug("Analysis Sample -> Contact Role : Name = " + contactRole.getContact().getName()
                        + " \t Address : " + contactRole.getContact().getAddress()
                        + " \t Role Accession : " + contactRole.getRole().getCvParam().getAccession());
            }


            assertEquals("We expect one CvParam.", 1, sample.getCvParams().size());
            assertEquals("We expect one UserParam.", 1, sample.getUserParams().size());

            sample.getCvParams().add(new CvParam());        // add a new CvParam
            assertEquals(2, sample.getCvParams().size());   // now there are two CvParams
            assertEquals(1, sample.getUserParams().size()); // still only one UserParam
            sample.getUserParams().add(new UserParam());    // add a new UserParam
            assertEquals(2, sample.getUserParams().size()); // now there are two UserParams
            assertEquals(2, sample.getCvParams().size());   // still only two CvParams
        }
    }

}
