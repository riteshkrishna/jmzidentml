package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftwareList;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * User: riteshk
 * Date: Sep 18, 2010
 */
public class AnalysisSoftwareTest extends TestCase {

    private static final Logger log = Logger.getLogger(AnalysisSoftwareTest.class);

    public void testAnalysisSoftwareInformation() throws Exception {

        URL xmlFileURL = AnalysisSoftwareTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        // Number of Analysis Software
        int totalAnalysisSoftware = unmarshaller.getObjectCountForXpath("/mzIdentML/AnalysisSoftwareList");
        assertEquals(1,totalAnalysisSoftware);

        Iterator<AnalysisSoftware> asl = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AnalysisSoftwareList/AnalysisSoftware", AnalysisSoftware.class);
        assertNotNull(asl);

        while(asl.hasNext()){
            AnalysisSoftware as = asl.next();
            assertNotNull(as);
            log.debug("\n Analysis Software -> Name : " + as.getName() + " \t Software : "
                    + as.getCustomizations() + "\t URI" + as.getURI());
            assertTrue("Analysis software is from Mascot.", as.getName().contains("Mascot"));
            log.debug("\n Analysis Software -> Contact -> Name  :" + as.getContactRole().getContact().getName());
            log.debug("\n Analysis Software -> Software -> Name :" + as.getSoftwareName().getCvParam().getName()
                    + "\t cvRef :" + as.getSoftwareName().getCvParam().getUnitCvRef());
            assertTrue("Analysis software name contains Mascot.", as.getSoftwareName().getCvParam().getName().contains("Mascot"));

            assertNull("We don't expect a UserParam in the SoftwareName tag!", as.getSoftwareName().getUserParam());
            CvParam cvParam = as.getSoftwareName().getCvParam();

            log.debug("cvParam name: " + cvParam.getName() + " acc: " + cvParam.getAccession() + "CV: " + cvParam.getCvRef());
            assertNotNull(cvParam.getAccession());
            assertEquals("PSI-MS", cvParam.getCvRef());

        }

        // check the same in another way
        AnalysisSoftwareList asList = unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisSoftwareList", AnalysisSoftwareList.class);
        assertNotNull(asList);
        for (AnalysisSoftware as : asList.getAnalysisSoftware()) {
            // same tests as above have to be true
            assertNotNull(as);
            assertTrue("Analysis software is from Mascot.", as.getName().contains("Mascot"));
            assertTrue("Analysis software name contains Mascot.", as.getSoftwareName().getCvParam().getName().contains("Mascot"));
            assertNull("We don't expect a UserParam in the SoftwareName tag!", as.getSoftwareName().getUserParam());
            CvParam cvParam = as.getSoftwareName().getCvParam();
            assertNotNull(cvParam.getAccession());
            assertEquals("PSI-MS", cvParam.getCvRef());
        }

    }

}
