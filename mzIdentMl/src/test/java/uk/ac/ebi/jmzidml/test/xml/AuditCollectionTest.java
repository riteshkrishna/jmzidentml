package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AuditCollection;
import uk.ac.ebi.jmzidml.model.mzidml.Contact;
import uk.ac.ebi.jmzidml.model.mzidml.Person;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */
public class AuditCollectionTest extends TestCase {

    Logger log = Logger.getLogger(AuditCollectionTest.class);

    public void testAuditCollectionInformation() throws Exception {

        URL xmlFileURL = AuditCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);


        Iterator<AuditCollection> aci = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AuditCollection", AuditCollection.class);
        assertNotNull(aci);

        int count = 0;
        while(aci.hasNext()){
            AuditCollection ac = aci.next();
            assertNotNull(ac);
            for (Contact contact : ac.getContactGroup()) {
                assertNotNull(contact);

                log.debug("Contact Count: " + (count++) + " Name: " + contact.getName()
                        + " Address: " + contact.getAddress() + " Email: " + contact.getEmail()
                        + " Fax: " + contact.getFax() + " Id: " + contact.getId()
                        + "Contact Class Name:" + contact.getClass().getName());
            }
        }

        // Resolve the organization_ref
        Iterator<Person> pi = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AuditCollection/Person",Person.class);
        while(pi.hasNext()){
            assertNotNull(pi);
            Person p = pi.next();
            assertNotNull(p);
            log.debug("Person: first name: " + p.getFirstName() + " last name:" + p.getLastName());

            assertEquals(1, p.getAffiliations().size()); // we expect one affiliation per person
            for (Person.Affiliations affiliation : p.getAffiliations()) {
                assertNotNull(affiliation);
                log.debug("Person -> Affiliation Name: " + affiliation.getOrganization().getName()
                        + " Address: " + affiliation.getOrganization().getAddress());
            }

        }

    }
}
