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


    Logger logger = Logger.getLogger(AnalysisCollectionTest.class);


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

        System.out.println("Protein Detection : " + pd.getId() + "\t" + pd.getName());
        ProteinDetectionList pdl = pd.getProteinDetectionList();
        System.out.println("Protein Detection List: Name : " + pdl.getName()
                             + "\t Id : " + pdl.getId());

        Iterator<ProteinAmbiguityGroup> pag =  pdl.getProteinAmbiguityGroup().iterator();
        while(pag.hasNext()){
            ProteinAmbiguityGroup pagInstance = pag.next();
            System.out.println("Protein Ambiguity Group : Id : " + pagInstance.getId()
                                + "\t Name :" + pagInstance.getName());

            Iterator<ProteinDetectionHypothesis>ph = pagInstance.getProteinDetectionHypothesis().iterator();
            while(ph.hasNext()){
                  ProteinDetectionHypothesis pdh = ph.next();
                  System.out.println(" Protein Detection Hypothesis : DBSequence Accn" + pdh.getDBSequenceProteinDetection().getAccession()
                                    + " seq length :"   + pdh.getDBSequenceProteinDetection().getLength());

                  Iterator<PeptideHypothesis> peph = pdh.getPeptideHypothesis().iterator();
                  while(peph.hasNext()){
                       PeptideEvidence pepevd = peph.next().getPeptideEvidence();
                       System.out.println("Peptide Evidence Name : " + pepevd.getName()
                                        + "\t Pre : "+ pepevd.getPre()
                                        + "\t Post :" + pepevd.getPost()
                                        + "\t DBSeq Accn :" + pepevd.getDBSequence().getAccession());
                  }
            }
        }

        System.out.println("********************************************************** ");
        System.out.println("**************** Spectrum Info *************************** ");
        System.out.println("********************************************************** ");

        while(si.hasNext()){

            SpectrumIdentification sid = si.next();
            System.out.println("SpectrumIdentification Id :" + sid.getId());


            SpectrumIdentificationProtocol sip = sid.getSpectrumIdentificationProtocol();
            System.out.println("Software Name :" + sip.getAnalysisSoftware().getSoftwareName().getParamGroup().getName());

            Iterator<InputSpectra> is = sid.getInputSpectra().iterator();
            System.out.println("Input Spectra : " + is.next().getSpectraData().getId());

            Iterator<SearchDatabase> sdb  = sid.getSearchDatabase().iterator();
            System.out.println("Search Database : " + sdb.next().getAnalysisSearchDatabase().getName());

            SpectrumIdentificationList spl = sid.getSpectrumIdentificationList();
            Iterator<SpectrumIdentificationResult> sr  = spl.getSpectrumIdentificationResult().iterator();
            System.out.println("SpectrumIdentificationResult Id : " + sr.next().getSpectrumID());
            
        }
        
    }

}
