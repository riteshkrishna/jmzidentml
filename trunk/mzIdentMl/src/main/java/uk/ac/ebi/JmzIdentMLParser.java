/**
 *
 * @author Ritesh
 */

package uk.ac.ebi;

import org.xml.sax.SAXException;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectIterator;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import javax.xml.parsers.ParserConfigurationException;
import java.net.URL;
import java.util.List;

public class JmzIdentMLParser {

    public static void main(String[] args) {
        List<SpectrumIdentificationItem> SpectrumIdentificationItem;

        try {

            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            if (xmlFileURL != null) {


                boolean aUseSpectrumCache = true;

                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);

                System.out.println("attempt to read contacts");
                ContactRole role = unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisSoftwareList/AnalysisSoftware/ContactRole", ContactRole.class);
                System.out.println("contactRole: " + role.getContact().getId());
                System.out.println("contactRole: " + role.getContact().getAddress());

                CvList list = unmarshaller.unmarshalFromXpath("/mzIdentML/cvList", CvList.class);
                System.out.println("list = " + list);

                MzIdentMLObjectIterator iter = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult", SpectrumIdentificationResult.class);
                while (iter.hasNext()) {
                    SpectrumIdentificationResult res = (SpectrumIdentificationResult) iter.next();
                    System.out.println("Peptide info = " + res.getSpectrumIdentificationItem().get(0).getPeptide().getId());

                     List<SpectrumIdentificationItem> SI = res.getSpectrumIdentificationItem();
                        for(int i = 0; i < SI.size(); i++){
                            if(!SI.get(i).getPeptideEvidence().isEmpty()){
                                List<PeptideEvidence> PE = SI.get(i).getPeptideEvidence();

                                for(int k = 0; k < PE.size(); k++){
                                    System.out.println("Peptide Evidence :: ID = " + PE.get(k).getId());
                                    System.out.println("Peptide Evidence :: DBSequence ID = " + PE.get(k).getDBSequence().getAccession());
                                    System.out.println("Peptide Evidence :: DBSequence Sequence = " + PE.get(k).getDBSequence().getSeq());

                                }
                            }
                        }
                }
               
                System.out.println("\n\n Testing Adapters in ProteinDetectionHypothesis : \n\n");

                MzIdentMLObjectIterator iterPD = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis", ProteinDetectionHypothesis.class);
                while(iterPD.hasNext()){
                    ProteinDetectionHypothesis ph = (ProteinDetectionHypothesis)iterPD.next();
                    System.out.println("ProteinDetectionHypothesis ID = " + ph.getId());
                    System.out.println("ProteinDetectionHypothesis : Resolved -- DB_Ref = " + ph.getDBSequenceProteinDetection().getId() + "\t" + ph.getDBSequenceProteinDetection().getAccession());

                    List <PeptideHypothesis> pepHyp = ph.getPeptideHypothesis();
                    System.out.println("Total Peptide Hypothesis :: " + pepHyp.size());
                    for(int s = 0; s < pepHyp.size() ; s++){
                    		PeptideEvidence phEvd = pepHyp.get(s).getPeptideEvidence();
                    		// To do :: This part resulting into null 
                    		if(phEvd != null)
                    			System.out.println("---- Resolved PeptideHypothesis :: PeptideEvidence = " + phEvd.getId());
                    }

                }

            } else {
                System.err.println("FILE NOT FOUND");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
