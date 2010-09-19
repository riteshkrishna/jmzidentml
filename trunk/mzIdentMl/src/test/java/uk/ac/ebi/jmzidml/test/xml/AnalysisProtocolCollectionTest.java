package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisProtocolCollection;
import uk.ac.ebi.jmzidml.model.mzidml.Enzymes;
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


    Logger logger = Logger.getLogger(AnalysisProtocolCollectionTest.class);


    public void testAnalysisProtocolCollectionInformation() throws Exception {

        URL xmlFileURL = AnalysisProtocolCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        AnalysisProtocolCollection apc =  unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisProtocolCollection", AnalysisProtocolCollection.class);

        ProteinDetectionProtocol pdp = apc.getProteinDetectionProtocol();
        System.out.println("ProteinDetectionProtocol Software Name : " + pdp.getAnalysisSoftware().getName());

        Iterator<SpectrumIdentificationProtocol> sip = apc.getSpectrumIdentificationProtocol().iterator();
        Enzymes enzymes = sip.next().getEnzymes();
        System.out.println("Enzyme Id :" + enzymes.getEnzyme().iterator().next().getId());
        
    }

}
