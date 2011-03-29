package uk.ac.ebi.jmzidml.test.xml.unmarshaller;

import junit.framework.TestCase;
import org.junit.Test;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.List;
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
        assertEquals("http://www.matrixscience.com/search_form_select.html", attributes.get("uri"));



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
        assertEquals("http://psidev.cvs.sourceforge.net/viewvc/*checkout*/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo", attributes.get("uri"));
    }


    @Test
    public void testRootAttributeRetrieval() throws Exception {
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        // check the root element (mzIdentML) attributes
        assertEquals("example_mzidentml_1", unmarshaller.getMzIdentMLId());
        assertEquals("1.1.0", unmarshaller.getMzIdentMLVersion());

        // now check all the other attributes
        String id = "example_mzidentml_1";
        Map<String, String> attributes = unmarshaller.getElementAttributes(id, MzIdentMLElement.MzIdentML.getClazz());
        assertNotNull(attributes);
        assertEquals(6, attributes.keySet().size());
        assertEquals("2009-08-18T17:59:55", attributes.get("creationDate"));
        assertEquals("http://psidev.info/psi/pi/mzIdentML/1.1", attributes.get("xmlns"));
        assertEquals("http://psidev.info/psi/pi/mzIdentML/1.1 ../resources/mzIdentML1.1.0.xsd", attributes.get("xsi:schemaLocation"));
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", attributes.get("xmlns:xsi"));
    }

    @Test
    public void testEnzymes() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        SpectrumIdentificationProtocol specutrumIdentificactionProtocol = unmarshaller.unmarshal(SpectrumIdentificationProtocol.class);
        Enzymes enzymes = specutrumIdentificactionProtocol.getEnzymes();
        assertTrue(enzymes.getEnzyme().get(0).getId().equals("ENZ_0"));
    }

    /**
     * Unmarshal Inputs and confirm that FileFormat adapter has successfully converted the
     * FileFormat  property into a CvParam in SourceFile
     *
     * @throws Exception
     */
    @Test
    public void testInputsUnmarshalWithFileFormatAdapter() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        Inputs inputs = unmarshaller.unmarshal(Inputs.class);
        assertTrue(inputs.getSourceFile().get(0).getFileFormat().getCvParam().getAccession().equals("MS:1001199"));
    }

    /**
     * Unmarshal SpectraData and confirm that SpectrumIDFormat adapter has successfully converted the
     * SpectrumIDFormat property into a list of CvParams in SpectraData.
     *
     * @throws Exception
     */
    @Test
    public void testInputsUnmarshalWithSpectrumIDFormatAdapter() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        SpectraData spectraData = unmarshaller.unmarshal(SpectraData.class);
        assertTrue(spectraData.getSpectrumIDFormat().getCvParam().getAccession().equals("MS:1001528"));
    }

    @Test
    public void testDataCollection() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        DataCollection dataCollection = unmarshaller.unmarshal(DataCollection.class);
        dataCollection.getInputs();
    }

    @Test
    public void testPeptideEvidenceList() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        PeptideEvidenceList peptideEvidenceList = unmarshaller.unmarshal(PeptideEvidenceList.class);
        assertTrue(peptideEvidenceList.getPeptideEvidence().size() > 0);
    }

    @Test
    public void testOrganization() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        Organization organization = unmarshaller.unmarshall(Organization.class, "ORG_MSL");
        assertTrue(organization.getParamGroup().size()==4);
        assertTrue(organization.getName().equals("Matrix Science Limited"));
        // Test facadelist
        List<CvParam> orgCvParams = organization.getCvParam();
        assertTrue(orgCvParams.size() == 2);
        assertTrue(orgCvParams.get(0).getAccession().equals("MS:1000589"));
        List<UserParam> orgUserParams = organization.getUserParam();
        assertTrue(orgUserParams.size() == 2);
        assertTrue(orgUserParams.get(0).getName().equals("contact phone"));

    }

    @Test
    public void testProvider() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        Provider provider = unmarshaller.unmarshall(Provider.class, "PROVIDER");
        assertTrue(provider.getContactRole().getRole().getCvParam().getAccession().equals("MS:1001271"));
    }

    @Test
    public void testAnalysisSampleCollection() throws Exception{
        URL xmlFileURL = MzIdentMLUnmarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        AnalysisSampleCollection analysisSampleCollection = unmarshaller.unmarshal(AnalysisSampleCollection.class);
        Sample sample = analysisSampleCollection.getSample().get(0);
        // Test facade list
        List<CvParam> sampleCvParams = sample.getCvParam();
        assertTrue(sample.getParamGroup().size() == 2);
        assertTrue(sampleCvParams.size() == 1);
        assertTrue(sampleCvParams.get(0).getUnitCvRef().equals("UO"));
        List<UserParam> sampleUserParams = sample.getUserParam();
        assertTrue(sampleUserParams.size() == 1);
        assertTrue(sampleUserParams.get(0).getUnitCvRef().equals("UO"));
    }
}
