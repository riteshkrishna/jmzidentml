package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AuditCollection;
import uk.ac.ebi.jmzidml.model.mzidml.Contact;
import uk.ac.ebi.jmzidml.model.mzidml.Organization;
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

    Logger logger = Logger.getLogger(AuditCollectionTest.class);


    public void testAuditCollectionInformation() throws Exception {

        URL xmlFileURL = AuditCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);


        Iterator<AuditCollection> aci = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AuditCollection",AuditCollection.class);
        int count = 0;
        while(aci.hasNext()){
            AuditCollection ac = aci.next();
            Iterator<Contact> contacti = ac.getContactGroup().iterator();
            while(contacti.hasNext()){
                Contact contact  = contacti.next();
                System.out.println("Contact Count : " + (++count));
                System.out.println("Audit Collection : Name " + contact.getName()
                                    + " \t Address : " + contact.getAddress()
                                    + " \t Email   : " + contact.getEmail()
                                    + " \t Fax     : " + contact.getFax()
                                    + " \t Id      : " + contact.getId());

                System.out.println("Contact Class Name :" + contact.getClass().getName());
            }
        }

        // Resolve the organization_ref
        Iterator<Person> pi = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AuditCollection/Person",Person.class);
        while(pi.hasNext()){
            Person p = pi.next();
            System.out.println("Person : first name : " + p.getFirstName() + "\t last name :" + p.getLastName());
            Iterator <Person.Affiliations> afi = p.getAffiliations().iterator();
            while(afi.hasNext()){
                Person.Affiliations af = afi.next();
                System.out.println("Person -> Affiliation Name : " + af.getOrganization().getName()
                                    + "\t Address : " + af.getOrganization().getAddress());
            }

        }

    }    
}
