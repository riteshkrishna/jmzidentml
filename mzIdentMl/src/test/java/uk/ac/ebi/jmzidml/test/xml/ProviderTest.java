/**
 *
 * User: riteshk
 * Date: Sep 18, 2010
 *
 */

package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.ContactRole;
import uk.ac.ebi.jmzidml.model.mzidml.Provider;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;

public class ProviderTest extends TestCase{

    Logger log = Logger.getLogger(ProviderTest.class);

    
    public void testProviderInformation() throws Exception {
        log.info("testing the <Provider> content.");
        URL xmlFileURL = ProviderTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        // Number of providers
        int totalProvider = unmarshaller.getObjectCountForXpath("/mzIdentML/Provider");
        assertEquals(1, totalProvider);

        Provider provider = unmarshaller.unmarshalFromXpath("/mzIdentML/Provider", Provider.class);
        assertNotNull(provider);

        assertEquals("PROVIDER", provider.getId());

        ContactRole cr = provider.getContactRole();
        assertNotNull(cr);
        assertEquals("researcher", cr.getRole().getCvParam().getName());
        assertTrue(cr.getContact().getEmail().contains("@"));

        // ToDo: maybe with other (more extensive) test file
//        if (provider.getAnalysisSoftware() != null){
//            System.out.println("\n Provider -> Analysis Software :" + provider.getAnalysisSoftware().getName());
//        }

    }
    
}
