package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisProtocolCollection;
import uk.ac.ebi.jmzidml.model.mzidml.Enzyme;
import uk.ac.ebi.jmzidml.model.mzidml.ProteinDetectionProtocol;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationProtocol;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */
public class AnalysisProtocolCollectionTest extends TestCase {


    private static final Logger log = Logger.getLogger(AnalysisProtocolCollectionTest.class);


    public void testAnalysisProtocolCollectionInformation() throws Exception {

        URL xmlFileURL = AnalysisProtocolCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        AnalysisProtocolCollection apc =  unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisProtocolCollection", AnalysisProtocolCollection.class);
        assertNotNull("AnalysisProtocolCollection can not be null.", apc);

        ProteinDetectionProtocol pdp = apc.getProteinDetectionProtocol();
        assertNotNull("ProteinDetectionProtocol can not be null.", pdp);
        log.debug("ProteinDetectionProtocol Software Name : " + pdp.getAnalysisSoftware().getName());
        assertEquals("Mascot Parser", pdp.getAnalysisSoftware().getName());

        Iterator<SpectrumIdentificationProtocol> sip = apc.getSpectrumIdentificationProtocol().iterator();
        assertNotNull("SpectrumIdentificationProtocol can not be null.", sip);
        Enzyme enzyme = sip.next().getEnzymes().getEnzyme().iterator().next();
        assertNotNull("Enzyme can not be null.", enzyme);
        log.debug("Enzyme Id :" + enzyme.getId());
        assertEquals("ENZ_0", enzyme.getId());

        String siteRegex = enzyme.getSiteRegexp();
        log.debug("Enzyme SiteRegex: " + siteRegex);
        assertNotNull(siteRegex);

    }

}
