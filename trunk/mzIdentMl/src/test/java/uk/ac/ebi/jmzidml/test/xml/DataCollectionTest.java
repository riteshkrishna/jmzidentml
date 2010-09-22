package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.List;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 19, 2010
 */
public class DataCollectionTest extends TestCase {

    Logger log = Logger.getLogger(DataCollectionTest.class);


    public void testDataCollectionInformation() throws Exception {

        URL xmlFileURL = DataCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        DataCollection dc =  unmarshaller.unmarshalFromXpath("/mzIdentML/DataCollection", DataCollection.class);
        assertNotNull(dc);

        Inputs dcInputs = dc.getInputs();
        assertNotNull(dcInputs);


        assertEquals(1, dcInputs.getSearchDatabase().size());
        AnalysisSearchDatabase asd = dcInputs.getSearchDatabase().get(0);

        String searchDB = asd.getId(); // store for later reference
        String searchDBName = asd.getName();
        assertEquals("SwissProt", searchDBName);
        assertEquals("SDB_SwissProt", searchDB);
        assertEquals("SwissProt_51.6.fasta", asd.getVersion());
        log.debug("Inout -> SearchDatabase Location:" + asd.getLocation() + " Id:" + asd.getId()
                + " Name:" + asd.getName() + " Version:" + asd.getVersion());
        assertNotNull(asd.getFileFormat());
        CvParam cvParam = asd.getFileFormat().getCvParam();
        assertNotNull(cvParam);
        assertEquals("MS:1001348", cvParam.getAccession());

        assertEquals(1, dcInputs.getSourceFile().size());
        SourceFile sourceFile = dcInputs.getSourceFile().get(0);
        assertNotNull(sourceFile);
        assertTrue(sourceFile.getLocation().endsWith(".dat"));
        log.debug("Input -> SourceFile : Location:" + sourceFile.getLocation());

        assertEquals(1, dcInputs.getSpectraData().size());
        SpectraData spectraData = dcInputs.getSpectraData().get(0);
        assertTrue(spectraData.getId().startsWith("SD"));
        assertEquals("MS:1001528", spectraData.getSpectrumIDFormat().getCvParam().getAccession());
        assertEquals("Mascot query number", spectraData.getSpectrumIDFormat().getCvParam().getName());


        //**********************************************************
        //**************** Analysis Data ***************************

        AnalysisData ad = dc.getAnalysisData();
        assertNotNull(ad);

        ProteinDetectionList pdl  = ad.getProteinDetectionList();
        assertNotNull(pdl);
        assertEquals("PDL_1", pdl.getId());

        assertEquals(5, pdl.getProteinAmbiguityGroup().size());
        for (ProteinAmbiguityGroup proteinAmbiguityGroup : pdl.getProteinAmbiguityGroup()) {
            assertTrue(proteinAmbiguityGroup.getId().startsWith("PAG_hit_"));

            assertTrue(proteinAmbiguityGroup.getProteinDetectionHypothesis().size() > 0);
            for (ProteinDetectionHypothesis proteinDetectionHypothesis : proteinAmbiguityGroup.getProteinDetectionHypothesis()) {
                assertNotNull(proteinDetectionHypothesis.getId());
                assertNotNull(proteinDetectionHypothesis.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getName());
                assertEquals(searchDB, proteinDetectionHypothesis.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getId());
                assertEquals(searchDBName, proteinDetectionHypothesis.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getName());

                for (PeptideHypothesis peptideHypothesis : proteinDetectionHypothesis.getPeptideHypothesis()) {
                    assertNotNull(peptideHypothesis.getPeptideEvidence());
                    assertTrue(peptideHypothesis.getPeptideEvidence().getId().startsWith("PE"));
                    assertTrue(peptideHypothesis.getPeptideEvidence().getDBSequence().getSeq().length() > 5);
                }
            }
        }


        List<SpectrumIdentificationList> sil = ad.getSpectrumIdentificationList();
        assertNotNull(sil);
        assertEquals(1, sil.size()); // only one spectrum identification list

        for (SpectrumIdentificationList sIdentList : sil) {
            assertTrue(sIdentList.getId().startsWith("SIL_"));

            assertEquals(3, sIdentList.getFragmentationTable().getMeasure().size());
            for (Measure measure : sIdentList.getFragmentationTable().getMeasure()) {
                assertTrue(measure.getId().startsWith("m_"));
                assertEquals(1, measure.getCvParam().size());
                assertTrue(measure.getCvParam().get(0).getName().startsWith("product ion"));
            }

            assertEquals(4, sIdentList.getSpectrumIdentificationResult().size());
            for (SpectrumIdentificationResult spectrumIdentResult : sIdentList.getSpectrumIdentificationResult()) {
                assertEquals(10, spectrumIdentResult.getSpectrumIdentificationItem().size());
                for (SpectrumIdentificationItem spectrumIdentItem : spectrumIdentResult.getSpectrumIdentificationItem()) {
                    assertTrue(spectrumIdentItem.getId().startsWith("SII_"));
                    int seqLength = spectrumIdentItem.getPeptide().getPeptideSequence().length();
                    assertTrue(seqLength > 5 && seqLength < 20); // peptide seq length is much shorter than the peptide evidence seq length

                    for (PeptideEvidence peptideEvidence : spectrumIdentItem.getPeptideEvidence()) {
                        assertTrue(peptideEvidence.getDBSequence().getSeq().length() > 30);
                    }
                } // end spectrum identification items
            } // end spectrum identification results

        } // end spectrum identifications
    } // end test method
}
