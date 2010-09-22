package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */
public class AnalysisCollectionTest extends TestCase {

    private static final Logger log = Logger.getLogger(AnalysisCollectionTest.class);

    public void testAnalysisCollectionInformation() throws Exception {

        URL xmlFileURL = AnalysisCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        AnalysisCollection asc =  unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisCollection", AnalysisCollection.class);
        assertNotNull(asc);

        ProteinDetection pd = asc.getProteinDetection();
        Iterator<SpectrumIdentification> si = asc.getSpectrumIdentification().iterator();
        assertNotNull(pd);
        assertNotNull(si);

        log.debug("Protein Detection: " + pd.getId() + "\t" + pd.getName());
        ProteinDetectionList pdl = pd.getProteinDetectionList();
        log.debug("Protein Detection List: Name: " + pdl.getName()
                             + "\t Id : " + pdl.getId());

        int pagCnt = pdl.getProteinAmbiguityGroup().size();
        assertTrue(pagCnt == 5);
        for (ProteinAmbiguityGroup proteinAmbiguityGroup : pdl.getProteinAmbiguityGroup()) {
            log.debug("Protein Ambiguity Group: Id: " + proteinAmbiguityGroup.getId()
                    + "\t Name: " + proteinAmbiguityGroup.getName());


            int pdhCnt = proteinAmbiguityGroup.getProteinDetectionHypothesis().size();
            assertTrue(pdhCnt > 0);
            for (ProteinDetectionHypothesis proteinDetectionHypothesis : proteinAmbiguityGroup.getProteinDetectionHypothesis()) {
                log.debug(" Protein Detection Hypothesis: DBSequence Accn: " + proteinDetectionHypothesis.getDBSequenceProteinDetection().getAccession()
                        + " seq length:" + proteinDetectionHypothesis.getDBSequenceProteinDetection().getLength());

                int phCnt = proteinDetectionHypothesis.getPeptideHypothesis().size();
                assertTrue(phCnt > 0);
                for (PeptideHypothesis peptideHypothesis : proteinDetectionHypothesis.getPeptideHypothesis()) {
                    PeptideEvidence pepevd = peptideHypothesis.getPeptideEvidence();
                    assertNotNull(pepevd);
                    assertNotNull(pepevd.getDBSequence());
                    log.debug("Peptide Evidence Name: " + pepevd.getName()
                            + "\t Pre: " + pepevd.getPre()
                            + "\t Post:" + pepevd.getPost()
                            + "\t DBSeq Accn:" + pepevd.getDBSequence().getAccession());
                }
            }
        }

//        System.out.println("********************************************************** ");
//        System.out.println("**************** Spectrum Info *************************** ");
//        System.out.println("********************************************************** ");

        while(si.hasNext()){

            SpectrumIdentification sid = si.next();
            log.debug("SpectrumIdentification Id :" + sid.getId());
            assertNotNull(sid.getId());


            SpectrumIdentificationProtocol sip = sid.getSpectrumIdentificationProtocol();
            log.debug("Software Name :" + sip.getAnalysisSoftware().getSoftwareName().getCvParam().getName());
            assertEquals("Mascot", sip.getAnalysisSoftware().getSoftwareName().getCvParam().getName());

            Iterator<InputSpectra> is = sid.getInputSpectra().iterator();
            String spectraID = is.next().getSpectraData().getId();
            log.debug("Input Spectra : " + spectraID);
            assertNotNull(spectraID);

            Iterator<SearchDatabase> sdb  = sid.getSearchDatabase().iterator();
            String searchDBName = sdb.next().getAnalysisSearchDatabase().getName();
            log.debug("Search Database : " + searchDBName);
            assertEquals("SwissProt", searchDBName);

            SpectrumIdentificationList spl = sid.getSpectrumIdentificationList();
            Iterator<SpectrumIdentificationResult> sr  = spl.getSpectrumIdentificationResult().iterator();
            String identResultSpectraID = sr.next().getSpectrumID();
            log.debug("SpectrumIdentificationResult Id : " + identResultSpectraID);
            assertNotNull(identResultSpectraID);
            
        }
        
    }

}
