package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.model.mzidml.params.SampleCvParam;
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

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        AnalysisSampleCollection asc =  unmarshaller.unmarshal(AnalysisSampleCollection.class);
        assertNotNull(asc);

        assertEquals(1, asc.getSample().size());
        for (Sample sample : asc.getSample()) {
            log.debug("Analysis Sample : Name = " + sample.getName());
            for (ContactRole contactRole : sample.getContactRole()) {
                if (MzIdentMLElement.ContactRole.isAutoRefResolving() && contactRole.getContactRef() != null) {
                    assertNotNull(contactRole.getContact());
                    log.debug("Analysis Sample -> Contact Role : Name = " + contactRole.getContact().getName()
                            + " \t Address : " + contactRole.getContact().getAddress()
                            + " \t Role Accession : " + contactRole.getRole().getCvParam().getAccession());
                    assertNotNull(contactRole.getContact().getName());
                    assertNotNull(contactRole.getRole());
                } else {
                    System.out.println("ContactRole is not auto-resolving or does not contain a Contact reference.");
                    assertNull(contactRole.getContact());
                }
            }


            assertEquals("We expect one CvParam.", 1, sample.getCvParam().size());
            assertEquals("We expect one UserParam.", 1, sample.getUserParam().size());
            CvParam param = sample.getCvParam().get(0);
            assertNotNull(param);
            assertTrue(param instanceof SampleCvParam);

            sample.getCvParam().add(new CvParam());        // add a new CvParam
            assertEquals(2, sample.getCvParam().size());   // now there are two CvParams
            assertEquals(1, sample.getUserParam().size()); // still only one UserParam
            sample.getUserParam().add(new UserParam());    // add a new UserParam
            assertEquals(2, sample.getUserParam().size()); // now there are two UserParams
            assertEquals(2, sample.getCvParam().size());   // still only two CvParams
        }
    }

}
