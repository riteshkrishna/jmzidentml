package uk.ac.ebi.jmzidml.test.xml.unmarshaller;

import junit.framework.TestCase;
import org.junit.Test;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware;
import uk.ac.ebi.jmzidml.model.mzidml.Cv;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Map;

/**
 * @author Florian Reisinger
 *         Date: 02-Dec-2010
 * @since 1.0
 */
public class MzIdentMLUnmarshallerTest extends TestCase {

    @Test
    public void testAttributeRetrieval() throws Exception {
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        // Number of providers
        int total = unmarshaller.getObjectCountForXpath(MzIdentMLElement.AnalysisSoftware.getXpath());
        assertEquals(2, total);

        AnalysisSoftware software = unmarshaller.unmarshal(MzIdentMLElement.AnalysisSoftware);
        assertNotNull(software);

        String id = "AS_mascot_server";
        Map<String, String> attributes = unmarshaller.getElementAttributes(id, MzIdentMLElement.AnalysisSoftware.getClazz());
        assertNotNull(attributes);
        // at the very least the id attribute has to be present
        // (otherwise we would not have found the element!)
        assertEquals(id, attributes.get("id"));

        // there should also be 4 attributes in this case
        // the 'id' plus 'name', 'version' and 'URI' attributes
        assertEquals(4, attributes.keySet().size());
        assertEquals("Mascot Server", attributes.get("name"));
        assertEquals("2.2.03", attributes.get("version"));
        assertEquals("http://www.matrixscience.com/search_form_select.html", attributes.get("URI"));



        // test with another element
        Cv cv = unmarshaller.unmarshal(MzIdentMLElement.CV);
        assertNotNull(cv);

        id = "PSI-MS";
        attributes = unmarshaller.getElementAttributes(id, MzIdentMLElement.CV.getClazz());
        assertNotNull(attributes);
        // at the very least the id attribute has to be present
        // (otherwise we would not have found the element!)
        assertEquals(id, attributes.get("id"));

        // there should also be 4 attributes in this case
        // the 'id' plus 'fullName', 'version' and 'URI' attributes
        assertEquals(4, attributes.keySet().size());
        assertEquals("Proteomics Standards Initiative Mass Spectrometry Vocabularies", attributes.get("fullName"));
        assertEquals("2.25.0", attributes.get("version"));
        assertEquals("http://psidev.cvs.sourceforge.net/viewvc/*checkout*/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo", attributes.get("URI"));

    }


    @Test
    public void testRootAttributeRetrieval() throws Exception {
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        // check the root element (mzIdentML) attributes
        assertEquals("example_mzidentml_1", unmarshaller.getMzIdentMLId());
        assertEquals("1.0.0", unmarshaller.getMzIdentMLVersion());

        // now check all the other attributes
        String id = "example_mzidentml_1";
        Map<String, String> attributes = unmarshaller.getElementAttributes(id, MzIdentMLElement.MzIdentML.getClazz());
        assertNotNull(attributes);
        assertEquals(6, attributes.keySet().size());
        assertEquals("2009-08-18T17:59:55", attributes.get("creationDate"));
        assertEquals("http://psidev.info/psi/pi/mzIdentML/1.0", attributes.get("xmlns"));
        assertEquals("http://psidev.info/psi/pi/mzIdentML/1.0 ../resources/mzIdentML1.0.0.xsd", attributes.get("xsi:schemaLocation"));
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", attributes.get("xmlns:xsi"));

    }

}
