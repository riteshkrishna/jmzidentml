package uk.ac.ebi.jmzidml.test.xml.marshaller;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLMarshaller;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import static junit.framework.Assert.assertNotNull;

/**
 * This test is not run automatically, since it only creates a mzIdentML output file.
 * No real additional testing is performed. It is just for manual checking.
 *
 * @author Florian Reisinger
 *         Date: 03-Dec-2010
 * @since 1.0
 */
@SuppressWarnings("unused")
public class MzIdentMLMarshallerTest {


    public void testIncrementalMarshalling() throws IOException {

        URL xmlFileURL = MzIdentMLMarshallerTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);
        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);


        MzIdentMLMarshaller m = new MzIdentMLMarshaller();
        assertNotNull(m);

        FileWriter writer = new FileWriter("output.xml");

        // mzIdentML
        //     cvList
        //     AnalysisSoftwareList
        //     Provider
        //     AuditCollection
        //     AnalysisSampleCollection
        //     SequenceCollection
        //     AnalysisCollection
        //     AnalysisProtocolCollection
        //     DataCollection
        //         Inputs
        //         AnalysisData
        //             SpectrumIdentificationList
        //             ProteinDetectionList
        //         /AnalysisData
        //     /DataCollection
        //     BibliographicReference
        // /mzIdentML


        // Note: writing of '\n' characters is optional and only for readability of the produced XML document
        // Also note: since the XML is produced in individual parts, the overall formatting of the document
        //            is not as nice as it would be when marshalling the whole structure at once.

        // XML header
        writer.write(m.createXmlHeader() + "\n");
        // mzIdentML start tag
        writer.write(m.createMzIdentMLStartTag("12345") + "\n");

        CvList cvList = unmarshaller.unmarshal(MzIdentMLElement.CvList.getXpath());
        m.marshall(cvList, writer);
        writer.write("\n");

        AnalysisSoftwareList analysisSoftwareList = unmarshaller.unmarshal(MzIdentMLElement.AnalysisSoftwareList.getXpath());
        m.marshall(analysisSoftwareList, writer);
        writer.write("\n");

        Provider provider = unmarshaller.unmarshal(MzIdentMLElement.Provider.getXpath());
        m.marshall(provider, writer);
        writer.write("\n");

        AuditCollection auditCollection = unmarshaller.unmarshal(MzIdentMLElement.AuditCollection.getXpath());
        m.marshall(auditCollection, writer);
        writer.write("\n");

        AnalysisSampleCollection analysisSampleCollection = unmarshaller.unmarshal(MzIdentMLElement.AnalysisSampleCollection.getXpath());
        m.marshall(analysisSampleCollection, writer);
        writer.write("\n");

        SequenceCollection sequenceCollection = unmarshaller.unmarshal(MzIdentMLElement.SequenceCollection.getXpath());
        m.marshall(sequenceCollection, writer);
        writer.write("\n");

        AnalysisCollection analysisCollection = unmarshaller.unmarshal(MzIdentMLElement.AnalysisCollection.getXpath());
        m.marshall(analysisCollection, writer);
        writer.write("\n");

        AnalysisProtocolCollection analysisProtocolCollection = unmarshaller.unmarshal(MzIdentMLElement.AnalysisProtocolCollection.getXpath());
        m.marshall(analysisProtocolCollection, writer);
        writer.write("\n");

        writer.write(m.createDataCollectionStartTag() + "\n");

        Inputs inputs = unmarshaller.unmarshal(MzIdentMLElement.Inputs.getXpath());
        m.marshall(inputs, writer);
        writer.write("\n");

        writer.write(m.createAnalysisDataStartTag() + "\n");

        writer.write(m.createSpectrumIdentificationListStartTag("SIL_1", null, 71412L) + "\n");

        FragmentationTable table = unmarshaller.unmarshal(MzIdentMLElement.FragmentationTable.getXpath());
        m.marshall(table, writer);
        writer.write("\n");

        Iterator<SpectrumIdentificationResult> specResIter = unmarshaller.unmarshalCollectionFromXpath(MzIdentMLElement.SpectrumIdentificationResult);
        while (specResIter.hasNext()) {
            SpectrumIdentificationResult specIdentRes = specResIter.next();
            m.marshall(specIdentRes, writer);
            writer.write("\n");
        }

        writer.write(m.createSpectrumIdentificationListClosingTag() + "\n");

        writer.write(m.createProteinDetectionListStartTag("PDL_1", null) + "\n");

        Iterator<ProteinAmbiguityGroup> protAmbGroupIter = unmarshaller.unmarshalCollectionFromXpath(MzIdentMLElement.ProteinAmbiguityGroup);
        while (protAmbGroupIter.hasNext()) {
            ProteinAmbiguityGroup protAmbGroup = protAmbGroupIter.next();
            m.marshall(protAmbGroup, writer);
            writer.write("\n");
        }

        writer.write(m.createProteinDetectionListClosingTag() + "\n");

        writer.write(m.createAnalysisDataClosingTag() + "\n");

        writer.write(m.createDataCollectionClosingTag() + "\n");

        BibliographicReference ref = unmarshaller.unmarshal(MzIdentMLElement.BibliographicReference.getXpath());
        m.marshall(ref, writer);
        writer.write("\n");

        writer.write(m.createMzIdentMLClosingTag());



    }

}
