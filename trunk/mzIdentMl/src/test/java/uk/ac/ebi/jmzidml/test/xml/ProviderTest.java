/**
 *
 * User: riteshk
 * Date: Sep 18, 2010
 *
 */

package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.net.URL;

import uk.ac.ebi.jmzidml.model.mzidml.ContactRole;
import uk.ac.ebi.jmzidml.model.mzidml.Provider;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

public class ProviderTest extends TestCase{

    Logger logger = Logger.getLogger(ProviderTest.class);

    
    public void testProviderInformation() throws Exception {

        URL xmlFileURL = ProviderTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        // Number of providers
        int totalProvider = unmarshaller.getObjectCountForXpath("/mzIdentML/Provider");
        assertEquals(1,totalProvider);

        Provider provider = unmarshaller.unmarshalFromXpath("/mzIdentML/Provider",Provider.class);
        assertNotNull(provider);

        System.out.println("Provider ID : " + provider.getId());

        ContactRole cr = provider.getContactRole();
        assertNotNull(cr);

        System.out.println("\n Provider -> Contact Role info : " + "Name : " + cr.getContact().getName()
                            + "\t" + "Role Name : "+ cr.getRole().getCvParam().getName()
                            + "\t" + "Address : "+ cr.getContact().getAddress()
                            + "\t" + "Emails : "+ cr.getContact().getEmail()
                            + "\t" + "Phone : "+ cr.getContact().getPhone());

        if (provider.getAnalysisSoftware() != null){
            System.out.println("\n Provider -> Analysis Software :" + provider.getAnalysisSoftware().getName());
        }

    }
    
}
